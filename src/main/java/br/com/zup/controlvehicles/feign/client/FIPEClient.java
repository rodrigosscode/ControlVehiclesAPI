package br.com.zup.controlvehicles.feign.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.zup.controlvehicles.dto.VeiculoDto;
import br.com.zup.controlvehicles.model.Ano;
import br.com.zup.controlvehicles.model.Marca;
import br.com.zup.controlvehicles.response.ModeloResponse;

@FeignClient(value="fipeService", url = "https://parallelum.com.br/fipe/api/v1")
public interface FIPEClient {

	@GetMapping(
			value="{tipoVeiculo}/marcas", 
			produces = "application/json"
	)
	public List<Marca> obtemMarcas(
			@PathVariable("tipoVeiculo") String tipoVeiculo
	);
	
	@GetMapping(
			value="{tipoVeiculo}/marcas/{codMarca}/modelos", 
			produces = "application/json"
	)
	public ModeloResponse obtemModelos(
			@PathVariable("tipoVeiculo") String tipoVeiculo,
			@PathVariable("codMarca") String codMarca
	);
	
	@GetMapping(
			value="{tipoVeiculo}/marcas/{codMarca}/modelos/{codModelo}/anos", 
			produces = "application/json"
	)
	public List<Ano> obtemAnos(
			@PathVariable("tipoVeiculo") String tipoVeiculo,
			@PathVariable("codMarca") String codMarca,
			@PathVariable("codModelo") String codModelo
	);
	
	@GetMapping(
			value="{tipoVeiculo}/marcas/{codMarca}/modelos/{codModelo}/anos/{codAno}", 
			produces = "application/json"
	)
	public VeiculoDto obtemVeiculo(
			@PathVariable("tipoVeiculo") String tipoVeiculo,
			@PathVariable("codMarca") String codMarca,
			@PathVariable("codModelo") String codModelo,
			@PathVariable("codAno") String codAno
	);
}
