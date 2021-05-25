package br.com.zup.controlvehicles.controller.form;

public class VeiculoForm {

	private String tipo = "";
	private String marca = "";
	private String modelo = "";
	private String ano = "";
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
