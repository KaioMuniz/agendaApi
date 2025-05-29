package br.com.cotiinformatica.repositories;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.cotiinformatica.entities.Tarefa;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, UUID> {

	/*
	 * JPQL - Java Persistence Query Language
	 * Consulta para retornar as tarefas do banco de dados
	 * dentro de um período de datas
	 */
	@Query("""
			SELECT t FROM Tarefa t
			WHERE t.dataHora BETWEEN :dataMin AND :dataMax
			ORDER BY t.dataHora DESC
			""")
	List<Tarefa> findByDatas(
			@Param("dataMin") Date dataMin, 
			@Param("dataMax") Date dataMax);
}
