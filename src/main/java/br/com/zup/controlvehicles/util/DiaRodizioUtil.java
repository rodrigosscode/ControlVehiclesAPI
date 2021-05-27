package br.com.zup.controlvehicles.util;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import br.com.zup.controlvehicles.model.Carro;

public class DiaRodizioUtil {

	private static Map<Integer, String> descricoesRodizio = new HashMap<>();
	private static final String SEGUNDA_FEIRA = "Segunda-feira";
	private static final String TERCA_FEIRA = "Terça-feira";
	private static final String QUARTA_FEIRA = "Quarta-feira";
	private static final String QUINTA_FEIRA = "Quinta-feira";
	private static final String SEXTA_FEIRA = "Sexta-feira";
	
	static {
		descricoesRodizio.put(0, SEGUNDA_FEIRA);
		descricoesRodizio.put(1, SEGUNDA_FEIRA);
		descricoesRodizio.put(2, TERCA_FEIRA);
		descricoesRodizio.put(3, TERCA_FEIRA);
		descricoesRodizio.put(4, QUARTA_FEIRA);
		descricoesRodizio.put(5, QUARTA_FEIRA);
		descricoesRodizio.put(6, QUINTA_FEIRA);
		descricoesRodizio.put(7, QUINTA_FEIRA);
		descricoesRodizio.put(8, SEXTA_FEIRA);
		descricoesRodizio.put(9, SEXTA_FEIRA);
	}
	
	public static String obtemDiaRodizioDescricao(Carro carro) {
		
		int ultimoDigitoAno = obtemUltimoDigitoAnoVeiculo(carro);
		String descricao = obtemDescricaoRodizioPeloUltimoDigitoAno(ultimoDigitoAno);
		
		return descricao;
	}
	
	public static boolean verificaRodizioAtivo(Carro carro) {
		
		LocalDate dataAtual = LocalDate.now();
		String diaAtualSemana = dataAtual.getDayOfWeek()
				.getDisplayName(TextStyle.FULL, new Locale("PT", "BR"));
		
		if (carro.getDiaRodizio().equals(diaAtualSemana)) {
			return true;
		}
		
		return false;
	}

	private static String obtemDescricaoRodizioPeloUltimoDigitoAno(int ultimoDigitoAno) {
		return descricoesRodizio.get(ultimoDigitoAno);
	}

	private static int obtemUltimoDigitoAnoVeiculo(Carro carro) {
		String ano = String.valueOf(carro.getAno());
		
		int ultimoDigitoAno = 
				Integer.parseInt(String.valueOf(
						ano.charAt(ano.length() - 1)
				));
		
		return ultimoDigitoAno;
	}
	
}
