package br.com.zup.controlvehicles.controller.form;

import javax.validation.constraints.NotBlank;

public class VeiculoForm {

	@NotBlank
	private String tipo = "";
	
	@NotBlank
	private String marca = "";
	
	@NotBlank
	private String modelo = "";
	
	@NotBlank
	private String ano = "";
	
	@NotBlank
	private Long usuarioId = null;
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
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
	
	public String getAno() {
		return ano;
	}
	
	public void setAno(String ano) {
		this.ano = ano;
	}
	
	public Long getUsuarioId() {
		return usuarioId;
	}
	
	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}

	@Override
	public String toString() {
		return "VeiculoForm [tipo=" + tipo + ", marca=" + marca + ", modelo=" + modelo + ", ano=" + ano + ", usuarioId="
				+ usuarioId + "]";
	}
}
