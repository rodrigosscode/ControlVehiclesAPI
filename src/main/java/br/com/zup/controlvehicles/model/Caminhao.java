package br.com.zup.controlvehicles.model;

import javax.persistence.Entity;

@Entity(name = "tbl_caminhao")
public class Caminhao extends Veiculo {

	@Override
	public TipoVeiculo getTipo() {
		return TipoVeiculo.CAMINHAO;
	}
}
