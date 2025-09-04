package br.com.cotiinformatica.domain.dtos;

import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class TarefaResponse {

	private UUID id;
	private String nome;
	private String descricao;
	private boolean concluida;
	
	@JsonFormat(
			shape = JsonFormat.Shape.STRING,
			pattern = "yyyy-MM-dd'T'HH:mm"
		)
	private LocalDateTime dataHora;	
}
