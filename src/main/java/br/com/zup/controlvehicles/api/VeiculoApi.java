package br.com.zup.controlvehicles.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.controlvehicles.controller.form.VeiculoForm;
import br.com.zup.controlvehicles.dto.VeiculoDto;
import br.com.zup.controlvehicles.model.Usuario;
import br.com.zup.controlvehicles.model.Veiculo;
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
			VeiculoDto veiculoDto = fipeApi.obtemVeiculo(
					veiculoForm.getTipo(), 
					veiculoForm.getMarca(), 
					veiculoForm.getModelo(), 
					veiculoForm.getAno()
			);
			
			Veiculo veiculo = veiculoDto.converteParaVeiculo();

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
	public ResponseEntity<List<Veiculo>> listarTodosPorUsuarioViaAPI(@PathVariable("usuarioId") Long usuarioId) {
		
		List<Veiculo> veiculos = veiculoService.obtemTodosPorUsuario(usuarioId);

		return ResponseEntity.ok(veiculos);
	}
}
