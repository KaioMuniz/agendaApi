package br.com.cotiinformatica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cotiinformatica.entities.Tarefa;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, String> {

}
