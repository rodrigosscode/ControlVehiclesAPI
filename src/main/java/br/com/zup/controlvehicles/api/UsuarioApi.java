package br.com.zup.controlvehicles.api;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
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
	public ResponseEntity<?> adicionar(@Valid @RequestBody UsuarioForm usuarioForm, BindingResult bindingResult) {
		
		try {
			if (bindingResult.hasErrors()) {
				
				List<String> erros = bindingResult.getAllErrors().stream()
						.map(ObjectError::getDefaultMessage).collect(Collectors.toList());
				
				throw new Exception(erros.toString());
				
			} else {
				Optional<Usuario> usuarioEncontrado = service.
						obtemPorEmailOuCPF(usuarioForm.getEmail(), usuarioForm.getCpf());
				
				if (usuarioEncontrado.isPresent()) {
					throw new Exception("Usuário já existente.");
				} else {
					Usuario usuario = usuarioForm.converteParaUsuario();
	
					service.salva(usuario);				
					return ResponseEntity.created(null).body(usuario);
				}
			}
		} catch (Exception e) {
			return ResponseEntity.badRequest()
					.body("Não foi possivel cadastrar o usuário verifique os dados.\n" + e.getMessage());
		}
	}
	
	@GetMapping("todos")
	public ResponseEntity<List<Usuario>> listarTodos() {
		
		List<Usuario> usuarios = service.obtemTodos();
		
		return ResponseEntity.ok(usuarios);
	}
	
}
