package br.com.zup.controlvehicles.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.controlvehicles.dto.VeiculoDto;
import br.com.zup.controlvehicles.feign.client.FIPEClient;
import br.com.zup.controlvehicles.model.Ano;
import br.com.zup.controlvehicles.model.Marca;
import br.com.zup.controlvehicles.response.ModeloResponse;

@RestController
@RequestMapping("fipe/api/veiculos")
public class FIPEApi {
	
	@Autowired
	private FIPEClient fipeClient;
	
	@GetMapping("{tipoVeiculo}/marcas")
	public ResponseEntity<?> obtemMarcas(@PathVariable("tipoVeiculo") String tipoVeiculo){
		try {
			List<Marca> marcas = fipeClient.obtemMarcas(tipoVeiculo);
			
			return ResponseEntity.ok(marcas);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Não foi possivel obter as marcas, verifique os dados");
		}
	}
	
	@GetMapping("{tipoVeiculo}/marcas/{codMarca}/modelos")
	public ResponseEntity<?> obtemModelos(@PathVariable("tipoVeiculo") String tipoVeiculo,
										@PathVariable("codMarca") String codMarca){
		try {
			ModeloResponse modeloResponse = fipeClient
					.obtemModelos(tipoVeiculo, codMarca);
			
			return ResponseEntity.ok(modeloResponse);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Não foi possivel obter os modelos, verifique os dados");
		}
	}
	
	@GetMapping("{tipoVeiculo}/marcas/{codMarca}/modelos/{codModelo}/anos")
	public ResponseEntity<?> obtemAnos(@PathVariable("tipoVeiculo") String tipoVeiculo,
								@PathVariable("codMarca") String codMarca,
								@PathVariable("codModelo") String codModelo){
		try {
			List<Ano> anos = fipeClient.obtemAnos(tipoVeiculo, codMarca, codModelo);			

			return ResponseEntity.ok(anos);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Não foi possivel obter os anos, verifique os dados");
		}
	}
	
	@GetMapping("{tipoVeiculo}/marcas/{codMarca}/modelos/{codModelo}/anos/{codAno}")
	public ResponseEntity<?> obtemVeiculo(@PathVariable("tipoVeiculo") String tipoVeiculo,
									@PathVariable("codMarca") String codMarca,
									@PathVariable("codModelo") String codModelo,
									@PathVariable("codAno") String codAno){
		
		try {
			VeiculoDto veiculoDto = fipeClient
					.obtemVeiculo(tipoVeiculo, codMarca, codModelo, codAno);
			
			return ResponseEntity.ok(veiculoDto);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Não foi possivel obter o veículo, verifique os dados");
		}
	}
}
