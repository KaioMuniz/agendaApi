package br.com.cotiinformatica.dtos;

import java.util.UUID;

public class CategoriaResponseDto {
	
	
	private UUID id;
	private String nome;
	
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	

}
