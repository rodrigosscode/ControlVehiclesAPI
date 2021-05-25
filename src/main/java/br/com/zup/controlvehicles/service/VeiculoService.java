package br.com.zup.controlvehicles.service;

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
}
