package br.com.zup.controlvehicles.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public List<Marca> obtemMarcas(@PathVariable("tipoVeiculo") String tipoVeiculo){
		
		List<Marca> marcas = fipeClient.obtemMarcas(tipoVeiculo);
		
		return marcas;
	}
	
	@GetMapping("{tipoVeiculo}/marcas/{codMarca}/modelos")
	public ModeloResponse obtemModelos(@PathVariable("tipoVeiculo") String tipoVeiculo,
										@PathVariable("codMarca") String codMarca){
		
		ModeloResponse modeloResponse = fipeClient
				.obtemModelos(tipoVeiculo, codMarca);
		
		return modeloResponse;
	}
	
	@GetMapping("{tipoVeiculo}/marcas/{codMarca}/modelos/{codModelo}/anos")
	public List<Ano> obtemAnos(@PathVariable("tipoVeiculo") String tipoVeiculo,
								@PathVariable("codMarca") String codMarca,
								@PathVariable("codModelo") String codModelo){
		
		List<Ano> anos = fipeClient
				.obtemAnos(tipoVeiculo, codMarca, codModelo);
		
		return anos;
	}
	
	@GetMapping("{tipoVeiculo}/marcas/{codMarca}/modelos/{codModelo}/anos/{codAno}")
	public VeiculoDto obtemVeiculo(@PathVariable("tipoVeiculo") String tipoVeiculo,
									@PathVariable("codMarca") String codMarca,
									@PathVariable("codModelo") String codModelo,
									@PathVariable("codAno") String codAno){
		
		VeiculoDto veiculoDto = fipeClient
				.obtemVeiculo(tipoVeiculo, codMarca, codModelo, codAno);
		
		return veiculoDto;
	}
}
