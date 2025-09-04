package br.com.cotiinformatica.repositories;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.cotiinformatica.domain.entities.Tarefa;

@Repository
public interface TarefaRepository extends MongoRepository<Tarefa, UUID> {

	//Buscar todas as tarefas de um determinado usuário
	List<Tarefa> findByUsuarioId(UUID usuarioId);
	
	//Buscar todas as tarefas de um determinado usuário dentro de um periodo de datas
	List<Tarefa> findByUsuarioIdAndDataHoraBetween(UUID usuarioId, LocalDateTime dataMin, LocalDateTime dataMax);
	
	//Buscar uma tarefa através do id do usuário e do id da tarefa
	Optional<Tarefa> findByIdAndUsuarioId(UUID id, UUID usuarioId);
}
