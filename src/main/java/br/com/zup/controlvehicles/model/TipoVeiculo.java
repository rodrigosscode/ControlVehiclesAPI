package br.com.zup.controlvehicles.model;

public enum TipoVeiculo {

	CARRO(1, "Carro", "carros"), 
	MOTO(2, "Moto", "motos"),
	CAMINHAO(3, "Caminhão", "caminhoes");
	
	private final int codTipoVeiculo;
	private final String valorExibicao;
	private final String valorBusca;
	
	TipoVeiculo(int codTipoVeiculo, String valorExibicao, String valorBusca) {
		this.codTipoVeiculo = codTipoVeiculo;
		this.valorExibicao = valorExibicao;
		this.valorBusca = valorBusca;
	}

	public int getCodTipoVeiculo() {
		return codTipoVeiculo;
	}

	public String getValorExibicao() {
		return valorExibicao;
	}

	public String getValorBusca() {
		return valorBusca;
	}	
	
	public static TipoVeiculo obtemPorCod(int codTipo) {
		for(TipoVeiculo tipo : values()) {
			if (tipo.codTipoVeiculo == codTipo) {
				return tipo;
			}
		}
		
		return null;
	}
}
