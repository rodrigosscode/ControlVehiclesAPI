package br.com.zup.controlvehicles.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.controlvehicles.feign.client.FIPEClient;
import br.com.zup.controlvehicles.model.Marca;

@RestController
@RequestMapping("marcas")
public class FIPEApi {
	
	@Autowired
	private FIPEClient fipeClient;
	
	@GetMapping()
	public List<Marca> obtemMarcas(){
		List<Marca> marcas = fipeClient.obtemMarcas();
		return marcas;
	}
}
