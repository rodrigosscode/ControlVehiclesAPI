package br.com.zup.controlvehicles.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zup.controlvehicles.model.Veiculo;
import br.com.zup.controlvehicles.repository.VeiculoRepository;

@Service
public class VeiculoService {

	@Autowired
	private VeiculoRepository repository;
	
	public void salva(Veiculo veiculo) {
		repository.save(veiculo);
	}
	
	public List<Veiculo> obtemTodos() {
		return (List<Veiculo>) repository.findAll();
	}
	
	public List<Veiculo> obtemTodosPorUsuario(Long usuarioId) {
		return (List<Veiculo>) repository.findAllByUserId(usuarioId);
	}
}
