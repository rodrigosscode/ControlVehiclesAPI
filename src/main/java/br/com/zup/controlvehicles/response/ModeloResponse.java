package br.com.zup.controlvehicles.response;

import java.util.List;

import br.com.zup.controlvehicles.model.Modelo;

public class ModeloResponse {
	
	private List<Modelo> modelos = null;

	public List<Modelo> getModelos() {
		return modelos;
	}

	public void setModelos(List<Modelo> modelos) {
		this.modelos = modelos;
	}
}
