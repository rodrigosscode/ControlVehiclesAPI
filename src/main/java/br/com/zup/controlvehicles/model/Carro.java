package br.com.zup.controlvehicles.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity(name = "tbl_carro")
@PrimaryKeyJoinColumn(name="veiculoId")
public class Carro extends Veiculo {

	private String diaRodizio = "";
	private boolean rodizioAtivo = false;
	
	public String getDiaRodizio() {
		return diaRodizio;
	}
	
	public void setDiaRodizio(String diaRodizio) {
		this.diaRodizio = diaRodizio;
	}
	
	public boolean isRodizioAtivo() {
		return rodizioAtivo;
	}
	
	public void setRodizioAtivo(boolean rodizioAtivo) {
		this.rodizioAtivo = rodizioAtivo;
	}
}
