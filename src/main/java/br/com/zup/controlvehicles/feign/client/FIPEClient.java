package br.com.zup.controlvehicles.feign.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.zup.controlvehicles.model.Marca;

@FeignClient(value="fipeService", url = "https://parallelum.com.br/fipe/api/v1/carros")
public interface FIPEClient {

	@GetMapping(value="/marcas", produces = "application/json")
	public List<Marca> obtemMarcas();
	
}
