package br.com.zup.controlvehicles.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.zup.controlvehicles.model.Veiculo;

public interface VeiculoRepository extends CrudRepository<Veiculo, Long>{

	@Query("SELECT v FROM Veiculo v WHERE v.usuario.id = :usuarioId")
	List<Veiculo> findAllByUserId(@Param("usuarioId")  Long usuarioId);
	
}
