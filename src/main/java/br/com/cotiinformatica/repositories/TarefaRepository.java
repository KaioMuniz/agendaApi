package br.com.cotiinformatica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cotiinformatica.entities.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, String> {

}
