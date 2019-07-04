package atividade.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import atividade.domain.Veiculo;

public interface VeiculoRepository extends CrudRepository<Veiculo, Long> {

	Optional<Veiculo> findByPlaca(String placa);
		
	@Query(value="SELECT u FROM Veiculo u")
	public Iterable<Veiculo> listarTodos();
	
	//@Query("SELECT c FROM Curso c WHERE c.cargaHoraria >= :inicio AND c.cargaHoraria <= :termino")
	@Query("SELECT c FROM Veiculo c WHERE c.valorDiaria BETWEEN :inicio AND :termino")
	public Iterable<Veiculo> buscaPorPrecoEntre(@Param("inicio") float inicio, @Param("termino") float termino);

	
	
}
