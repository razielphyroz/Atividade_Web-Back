package atividade.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import atividade.domain.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {

	@Query("SELECT c FROM Cliente c WHERE c.cpf = :cpf")
	Optional<Cliente> buscarPorCpf(@Param("cpf") String cpf); 
	
	@Query("SELECT c FROM Cliente c WHERE c.nome like %:nome")
	Optional<Cliente> buscarPorNome(@Param("nome") String nome);
	


}
