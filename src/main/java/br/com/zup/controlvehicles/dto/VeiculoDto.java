package br.com.zup.controlvehicles.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.zup.controlvehicles.entity.Caminhao;
import br.com.zup.controlvehicles.entity.Carro;
import br.com.zup.controlvehicles.entity.Moto;
import br.com.zup.controlvehicles.entity.Veiculo;
import br.com.zup.controlvehicles.model.TipoVeiculo;
import br.com.zup.controlvehicles.util.DiaRodizioUtil;

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
	
	public Veiculo converteParaVeiculo() {
		Veiculo veiculo = null;
		
		if (tipoVeiculo == TipoVeiculo.CARRO.getCodTipoVeiculo()) {
			veiculo = new Carro();
			Carro carro = (Carro) veiculo;
			carro.setDiaRodizio(DiaRodizioUtil.obtemDiaRodizioDescricao(carro));
		} else if (tipoVeiculo == TipoVeiculo.MOTO.getCodTipoVeiculo()) {
			veiculo = new Moto();
		} else {
			veiculo = new Caminhao();
		}
		
		veiculo.setMarca(marca);
		veiculo.setModelo(modelo);
		veiculo.setAno(anoModelo);
		
		return veiculo;
	}
}
