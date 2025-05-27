package br.com.cotiinformatica.dtos;

import java.util.UUID;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class TarefaRequestDto {
	
	@Size(min = 3, max = 150, message = "O título da tarefa deve ter entre 3 e 150 caracteres.")
	@NotEmpty(message = "O título da tarefa deve ser informado.")
	private String titulo;
	
	@Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "A data da tarefa deve estar no formato yyyy/MM/dd/.")
	@NotEmpty(message = "A data da tarefa deve ser informada.")
	private String data;
	
	@Pattern(regexp = "^\\d{2}:\\d{2}$", message = "A hora da tarefa deve estar no formato HH:mm.")
	@NotEmpty(message = "A hora da tarefa deve ser informada.")
	private String hora;
	
	@NotNull(message = "O status da tarefa deve ser informado.")
	private Boolean finalizada;
	
	@NotNull(message = "A categoria da tarefa deve ser informada.")
	private UUID categoriaId;
	
	
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public Boolean getFinalizada() {
		return finalizada;
	}
	public void setFinalizada(Boolean finalizada) {
		this.finalizada = finalizada;
	}
	public UUID getCategoriaId() {
		return categoriaId;
	}
	public void setCategoriaId(UUID categoriaId) {
		this.categoriaId = categoriaId;
	}

}
