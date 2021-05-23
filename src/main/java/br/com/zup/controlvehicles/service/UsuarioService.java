package br.com.zup.controlvehicles.service;

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
}
