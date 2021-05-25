package br.com.zup.controlvehicles.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zup.controlvehicles.model.Usuario;
import br.com.zup.controlvehicles.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
	public void salva(Usuario usuario) {
		repository.save(usuario);
	}
	
	public Optional<Usuario> obtemPorId(Long id) {
		return repository.findById(id);
	}
	
	public List<Usuario> obtemTodos() {
		return (List<Usuario>) repository.findAll();
	}
}
