package br.com.zup.controlvehicles.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.zup.controlvehicles.entity.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long>{

	@Query(value="SELECT u FROM tbl_usuario u WHERE u.email LIKE :email OR u.cpf LIKE :cpf")
	Optional<Usuario> findByEmailOrCPF(@Param("email") String email, @Param("cpf") String cpf);
	
}