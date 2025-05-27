package br.com.cotiinformatica.dtos;

import java.util.UUID;

public class TarefaResponseDto {

	private UUID id;
	private String titulo;
	private String data;
	private String hora;
	private Boolean finalizado;
	private CategoriaResponseDto categoria;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

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

	public Boolean getFinalizado() {
		return finalizado;
	}

	public void setFinalizado(Boolean finalizado) {
		this.finalizado = finalizado;
	}

	public CategoriaResponseDto getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaResponseDto categoria) {
		this.categoria = categoria;
	}

}
