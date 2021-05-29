package br.com.zup.controlvehicles.entity;

import javax.persistence.Entity;

import br.com.zup.controlvehicles.model.TipoVeiculo;

@Entity(name = "tbl_caminhao")
public class Caminhao extends Veiculo {

	@Override
	public TipoVeiculo getTipo() {
		return TipoVeiculo.CAMINHAO;
	}
}
