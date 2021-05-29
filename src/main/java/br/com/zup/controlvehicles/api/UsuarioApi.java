package br.com.zup.controlvehicles.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.controlvehicles.controller.form.UsuarioForm;
import br.com.zup.controlvehicles.entity.Usuario;
import br.com.zup.controlvehicles.service.UsuarioService;

@RestController
@RequestMapping("api/usuarios")
public class UsuarioApi {
	
	@Autowired
	private UsuarioService service;
	
	@PostMapping("adiciona")
	public ResponseEntity<?> adicionar(@RequestBody UsuarioForm usuarioForm) {
		
		Usuario usuario = usuarioForm.converteParaUsuario();
		
		try {
			service.salva(usuario);
			
			return ResponseEntity.created(null).body(usuario);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Não foi possivel cadastrar o usuario verifique os dados.");
		}
	}
	
	@GetMapping("todos")
	public ResponseEntity<List<Usuario>> listarTodos() {
		
		List<Usuario> usuarios = service.obtemTodos();
		
		return ResponseEntity.ok(usuarios);
	}
	
}
