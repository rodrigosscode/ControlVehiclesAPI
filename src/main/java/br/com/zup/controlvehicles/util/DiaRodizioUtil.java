package br.com.zup.controlvehicles.util;

import br.com.zup.controlvehicles.model.Carro;

public class DiaRodizioUtil {

	public static String obtemDiaRodizioDescricao(Carro carro) {
		String descricao = "";
		
		String ano = String.valueOf(carro.getAno());
		
		int ultimoDigitoAno = 
				Integer.parseInt(String.valueOf(
						ano.charAt(ano.length() - 1)
				));
		
		if (ultimoDigitoAno == 0 || ultimoDigitoAno == 1) {
			descricao = "segunda-feira";
		} else if (ultimoDigitoAno == 2 || ultimoDigitoAno == 3) {
			descricao = "terça-feira";
		} else if (ultimoDigitoAno == 4 || ultimoDigitoAno == 5) {
			descricao = "quarta-feira";
		} else if (ultimoDigitoAno == 6 || ultimoDigitoAno == 7) {
			descricao = "quinta-feira";
		} else if (ultimoDigitoAno == 8 || ultimoDigitoAno == 9) {
			descricao = "sexta-feira";
		}
		
		return descricao;
	}
	
}
