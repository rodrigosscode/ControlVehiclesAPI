package br.com.zup.controlvehicles.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.zup.controlvehicles.controller.form.UsuarioForm;
import br.com.zup.controlvehicles.model.Usuario;
import br.com.zup.controlvehicles.service.UsuarioService;

@Controller
@RequestMapping("cadastro-usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;
	
	@GetMapping()
	public ModelAndView cadastrar() {
		ModelAndView modelAndView = new ModelAndView("cadastro-usuario");
		return modelAndView;
	}
	
	@PostMapping()
	public ModelAndView cadastrar(UsuarioForm usuarioForm) {
		
		Usuario usuario = usuarioForm.converteParaUsuario();
		service.salva(usuario);
		
		ModelAndView modelAndView = new ModelAndView("redirect:cadastro-usuario");
		return modelAndView;
	}
}
