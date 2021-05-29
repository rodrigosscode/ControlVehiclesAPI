package br.com.zup.controlvehicles.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.zup.controlvehicles.entity.Usuario;
import br.com.zup.controlvehicles.service.UsuarioService;

@Controller
@RequestMapping("lista-veiculos-usuario")
public class ListaVeiculosUsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping()
	public ModelAndView listarVeiculos() {
		ModelAndView modelAndView = new ModelAndView("lista-veiculos-usuario");
		
		List<Usuario> usuarios = usuarioService.obtemTodos();
		modelAndView.addObject("usuarios", usuarios);
		
		return modelAndView;
	}
}
