package br.com.cotiinformatica.domain.dtos;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class TarefaRequest {

	@NotBlank(message = "O nome da tarefa é obrigatório.")
	@Size(min = 8, max = 100, message = "O nome da tarefa deve estar entre 8 e 100 caracteres.")
	private String nome;
	
	@NotBlank(message = "A descrição da tarefa é obrigatória.")
	@Size(min = 8, max = 250, message = "A descrição da tarefa deve estar entre 8 e 250 caracteres.")
	private String descricao;
	
	@NotNull(message = "O status de conclusão é obrigatório.")
	private Boolean concluida;
	
	@NotNull(message = "A data e hora da tarefa é obrigatória.")
	@JsonFormat(
		shape = JsonFormat.Shape.STRING,
		pattern = "yyyy-MM-dd'T'HH:mm"
	)
	private LocalDateTime dataHora;
}
