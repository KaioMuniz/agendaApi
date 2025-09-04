package br.com.cotiinformatica.domain.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Document(collection = "tarefas")
public class Tarefa {

	@Id	
	private UUID id;
	private String nome;
	private String descricao;
	private boolean concluida;
	private LocalDateTime dataHora;
	private UUID usuarioId;
	
	public Tarefa() {
		this.id = UUID.randomUUID();
	}
}
