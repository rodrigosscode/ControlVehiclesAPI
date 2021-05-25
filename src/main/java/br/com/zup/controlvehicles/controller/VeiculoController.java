package br.com.zup.controlvehicles.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.com.zup.controlvehicles.api.FIPEApi;
import br.com.zup.controlvehicles.controller.form.VeiculoForm;
import br.com.zup.controlvehicles.dto.VeiculoDto;
import br.com.zup.controlvehicles.model.TipoVeiculo;
import br.com.zup.controlvehicles.model.Usuario;
import br.com.zup.controlvehicles.model.Veiculo;
import br.com.zup.controlvehicles.service.UsuarioService;
import br.com.zup.controlvehicles.service.VeiculoService;

@RestController
public class VeiculoController {
	
	@Autowired
	private VeiculoService veiculoService;
	
	@Autowired 
	private FIPEApi fipeApi;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("cadastro-veiculo")
	public ModelAndView cadastrar() {
		ModelAndView modelAndView = new ModelAndView("cadastro-veiculo");
		modelAndView.addObject("tipos", TipoVeiculo.values());

		return modelAndView;
	}
	
	@PostMapping("cadastro-veiculo")
	public ModelAndView cadastrar(VeiculoForm veiculoForm) {
		
		VeiculoDto veiculoDto = fipeApi.obtemVeiculo(
				veiculoForm.getTipo(), 
				veiculoForm.getMarca(), 
				veiculoForm.getModelo(), veiculoForm.getAno());
		
		Veiculo veiculo = veiculoDto.toVeiculo();

		Optional<Usuario> usuario = usuarioService.obtemPorId(veiculoForm.getUsuarioId());
		if (usuario.isPresent()) {
			veiculo.setUsuario(usuario.get());
		}
		
		veiculoService.salva(veiculo);

		ModelAndView modelAndView = new ModelAndView("cadastro-veiculo");
		return modelAndView;
	}
	
	@PostMapping("cadastro-veiculo/veiculos/adiciona")
	public ResponseEntity<Veiculo> adicionarViaAPI(@RequestBody VeiculoForm veiculoForm) {
		
		VeiculoDto veiculoDto = fipeApi.obtemVeiculo(
				veiculoForm.getTipo(), 
				veiculoForm.getMarca(), 
				veiculoForm.getModelo(), veiculoForm.getAno());
		
		Veiculo veiculo = veiculoDto.toVeiculo();

		Optional<Usuario> usuario = usuarioService.obtemPorId(veiculoForm.getUsuarioId());
		if (usuario.isPresent()) {
			veiculo.setUsuario(usuario.get());
		}
		
		veiculoService.salva(veiculo);

		return new ResponseEntity<Veiculo>(veiculo, HttpStatus.CREATED);
	}
	
}
