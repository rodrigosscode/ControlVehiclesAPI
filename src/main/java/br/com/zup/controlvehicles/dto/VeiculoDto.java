package br.com.zup.controlvehicles.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.zup.controlvehicles.model.Caminhao;
import br.com.zup.controlvehicles.model.Carro;
import br.com.zup.controlvehicles.model.Moto;
import br.com.zup.controlvehicles.model.TipoVeiculo;
import br.com.zup.controlvehicles.model.Veiculo;

public class VeiculoDto {

	@JsonProperty("Valor")
	private String valor = "";
	
	@JsonProperty("Marca")
	private String marca = "";
	
	@JsonProperty("Modelo")
	private String modelo = "";
	
	@JsonProperty("AnoModelo")
	private int anoModelo = 0;
	
	@JsonProperty("Combustivel")
	private String combustivel = "";
	
	@JsonProperty("CodigoFipe")
	private String codigoFipe = "";
	
	@JsonProperty("MesReferencia")
	private String mesReferencia = "";
	
	@JsonProperty("TipoVeiculo")
	private int tipoVeiculo = 0;
	
	@JsonProperty("SiglaCombustivel")
	private String siglaCombustivel = "";
	
	public String getValor() {
		return valor;
	}
	
	public void setValor(String valor) {
		this.valor = valor;
	}
	
	public String getMarca() {
		return marca;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public int getAnoModelo() {
		return anoModelo;
	}
	
	public void setAnoModelo(int anoModelo) {
		this.anoModelo = anoModelo;
	}
	
	public String getCombustivel() {
		return combustivel;
	}
	
	public void setCombustivel(String combustivel) {
		this.combustivel = combustivel;
	}
	
	public String getCodigoFipe() {
		return codigoFipe;
	}
	
	public void setCodigoFipe(String codigoFipe) {
		this.codigoFipe = codigoFipe;
	}
	
	public String getMesReferencia() {
		return mesReferencia;
	}
	
	public void setMesReferencia(String mesReferencia) {
		this.mesReferencia = mesReferencia;
	}
	
	public int getTipoVeiculo() {
		return tipoVeiculo;
	}
	
	public void setTipoVeiculo(int tipoVeiculo) {
		this.tipoVeiculo = tipoVeiculo;
	}
	
	public String getSiglaCombustivel() {
		return siglaCombustivel;
	}
	
	public void setSiglaCombustivel(String siglaCombustivel) {
		this.siglaCombustivel = siglaCombustivel;
	}
	
	public Veiculo toVeiculo() {
		Veiculo veiculo = null;
		
		if (this.tipoVeiculo == TipoVeiculo.CARRO.getCodTipoVeiculo()) {
			veiculo = new Carro();
		} else if (this.tipoVeiculo == TipoVeiculo.MOTO.getCodTipoVeiculo()) {
			veiculo = new Moto();
		} else {
			veiculo = new Caminhao();
		}
		
		veiculo.setMarca(this.marca);
		veiculo.setModelo(this.modelo);
		veiculo.setAno(this.anoModelo);
		
		return veiculo;
	}

	@Override
	public String toString() {
		return "VeiculoDto [valor=" + valor + ", marca=" + marca + ", modelo=" + modelo + ", anoModelo=" + anoModelo
				+ ", combustivel=" + combustivel + ", codigoFipe=" + codigoFipe + ", mesReferencia=" + mesReferencia
				+ ", tipoVeiculo=" + tipoVeiculo + ", siglaCombustivel=" + siglaCombustivel + "]";
	}
}
