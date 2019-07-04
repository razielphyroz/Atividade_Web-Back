package atividade.repositories;

import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import atividade.domain.Locacao;
import atividade.projections.LocacaoProjection;

public interface LocacaoRepository extends CrudRepository<Locacao, Long> {

	@Query("SELECT l FROM Locacao l order by datatermino desc")
	Iterable<LocacaoProjection> buscarTodasLocacoes(@Param("data") Date data);
	
	@Query("SELECT l FROM Locacao l WHERE :data >= datainicio AND :data <= datatermino order by datatermino desc")
	Iterable<LocacaoProjection> buscarLocacoesAtivasProjection(@Param("data") Date data);
	
}
