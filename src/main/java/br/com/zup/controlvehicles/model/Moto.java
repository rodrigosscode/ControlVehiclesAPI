package br.com.zup.controlvehicles.model;

import javax.persistence.Entity;

@Entity(name = "tbl_moto")
public class Moto extends Veiculo {

	@Override
	public TipoVeiculo getTipo() {
		return TipoVeiculo.MOTO;
	}
}
