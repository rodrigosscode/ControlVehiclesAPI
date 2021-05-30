package br.com.zup.controlvehicles.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.controlvehicles.controller.form.VeiculoForm;
import br.com.zup.controlvehicles.dto.VeiculoDto;
import br.com.zup.controlvehicles.entity.Usuario;
import br.com.zup.controlvehicles.entity.Veiculo;
import br.com.zup.controlvehicles.service.UsuarioService;
import br.com.zup.controlvehicles.service.VeiculoService;

@RestController
@RequestMapping("api/veiculos")
public class VeiculoApi {
	
	@Autowired
	private VeiculoService veiculoService;
	
	@Autowired 
	private FIPEApi fipeApi;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping("adiciona")
	public ResponseEntity<?> adicionar(@RequestBody VeiculoForm veiculoForm) {
		
		try {
			
			ResponseEntity<?> veiculoDto = fipeApi.obtemVeiculo(
					veiculoForm.getTipo(), 
					veiculoForm.getMarca(), 
					veiculoForm.getModelo(), 
					veiculoForm.getAno()
			);
			
			if (veiculoDto.getStatusCode() == HttpStatus.BAD_REQUEST) {
				throw new Exception();
			}
			
			Veiculo veiculo = ((VeiculoDto) veiculoDto.getBody()).converteParaVeiculo();

			Optional<Usuario> usuario = usuarioService.obtemPorId(veiculoForm.getUsuarioId());
			if (usuario.isPresent()) {
				veiculo.setUsuario(usuario.get());
				
				veiculoService.salva(veiculo);

				return ResponseEntity.created(null).body(veiculo);
			} else {
				return ResponseEntity.badRequest().body("Não foi possivel cadastrar o veículo, usuário inexistente.");
			}
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Não foi possivel cadastrar o veículo verifique os dados.");
		}
	}
	
	@GetMapping("todos")
	public ResponseEntity<List<Veiculo>> listarTodos() {
		
		List<Veiculo> veiculos = veiculoService.obtemTodos();
	
		return ResponseEntity.ok(veiculos);
	}
	
	@GetMapping("todos/usuario/{usuarioId}")
	public ResponseEntity<?> listarTodosPorUsuarioViaAPI(@PathVariable("usuarioId") String usuarioId) {
		
		try {
			long id = Long.parseLong(usuarioId);
			Optional<Usuario> usuario = usuarioService.obtemPorId(id);
			
			if (!usuario.isPresent()) {
				return new ResponseEntity<String>("Usuário não foi encontrado", HttpStatus.NOT_FOUND);
			}
			
			List<Veiculo> veiculos = veiculoService.obtemTodosPorUsuario(id);
			
			return ResponseEntity.ok(veiculos);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Não foi possivel realizar sua solicitação");
		}
	}
}
