package br.com.zup.controlvehicles.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.com.zup.controlvehicles.model.Usuario;
import br.com.zup.controlvehicles.service.UsuarioService;

@RestController
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;
	
	@GetMapping("cadastro-usuario")
	public ModelAndView cadastrar() {
		System.out.println("GET: cadastro-usuario");
		ModelAndView modelAndView = new ModelAndView("cadastro-usuario");
		return modelAndView;
	}
	
	@PostMapping("cadastro-usuario")
	public ModelAndView cadastrar(Usuario usuario) {
		System.out.println("POST: Usuário via (Formulário): " + usuario);
		service.salva(usuario);
		ModelAndView modelAndView = new ModelAndView("cadastro-usuario");
		modelAndView.setStatus(HttpStatus.CREATED);
		return modelAndView;
	}
	
	@PostMapping("cadastro-usuario/usuarios/adiciona")
	public ResponseEntity<Usuario> adicionarViaAPI(@RequestBody Usuario usuario) {
		System.out.println("POST: Usuário via (REST API): " + usuario);
		service.salva(usuario);
		return new ResponseEntity<Usuario>(usuario, HttpStatus.CREATED);
	}
	
	@GetMapping(value="cadastro-usuario/usuarios/todos")
	public ResponseEntity<List<Usuario>> listarViaAPI() {
		System.out.println("GET: Todos Usuários via (REST API): ");		
		List<Usuario> usuarios = service.obtemTodos();
		return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.ACCEPTED);
	}
	
}
