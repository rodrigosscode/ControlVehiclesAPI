package br.com.zup.controlvehicles.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.zup.controlvehicles.model.TipoVeiculo;
import br.com.zup.controlvehicles.service.VeiculoService;

@Controller
public class VeiculoController {
	
	@Autowired
	private VeiculoService service;
	
	@GetMapping("cadastro-veiculo")
	public ModelAndView cadastrar() {
		ModelAndView modelAndView = new ModelAndView("cadastro-veiculo");
		modelAndView.addObject("tipos", TipoVeiculo.values());

		return modelAndView;
	}
	
}
