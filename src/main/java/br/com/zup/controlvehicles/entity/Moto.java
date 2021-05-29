package br.com.zup.controlvehicles.entity;

import javax.persistence.Entity;

import br.com.zup.controlvehicles.model.TipoVeiculo;

@Entity(name = "tbl_moto")
public class Moto extends Veiculo {

	@Override
	public TipoVeiculo getTipo() {
		return TipoVeiculo.MOTO;
	}
}
