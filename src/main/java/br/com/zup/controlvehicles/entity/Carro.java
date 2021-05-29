package br.com.zup.controlvehicles.entity;

import javax.persistence.Entity;
import javax.persistence.Transient;

import br.com.zup.controlvehicles.model.TipoVeiculo;
import br.com.zup.controlvehicles.util.DiaRodizioUtil;

@Entity(name = "tbl_carro")
public class Carro extends Veiculo {

	@Transient
	private String diaRodizio = "";
	
	@Transient
	private boolean rodizioAtivo = false;
	
	public String getDiaRodizio() {
		return DiaRodizioUtil.obtemDiaRodizioDescricao(this);
	}
	
	public void setDiaRodizio(String diaRodizio) {
		this.diaRodizio = diaRodizio;
	}
	
	public boolean isRodizioAtivo() {
		return DiaRodizioUtil.verificaRodizioAtivo(this);
	}
	
	public void setRodizioAtivo(boolean rodizioAtivo) {
		this.rodizioAtivo = rodizioAtivo;
	}
	
	@Override
	public TipoVeiculo getTipo() {
		return TipoVeiculo.CARRO;
	}
}
