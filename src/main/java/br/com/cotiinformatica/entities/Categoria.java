package br.com.cotiinformatica.entities;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "tb_categoria")
public class Categoria {
	
	@Id
	@Column(name = "id")
	private UUID id;
	
	@Column(length = 100, nullable = false, unique = true)
	private String nome;
	
	@OneToMany(mappedBy = "categoria")
	private List<Tarefa> tarefas;
	
	
	
	
	
	public Categoria() {
        super();
    }
	
	public Categoria(UUID id, String nome, List<Tarefa> tarefas) {
		super();
		this.id = id;
		this.nome = nome;
		this.tarefas = tarefas;
		
	}

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

	public List<Tarefa> getTarefas() {
		return tarefas;
	}

	public void setTarefas(List<Tarefa> tarefas) {
		this.tarefas = tarefas;
	}
	

}
