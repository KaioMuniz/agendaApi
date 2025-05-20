	package br.com.cotiinformatica.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/v1/tarefas")
public class TarefaController {

		@PostMapping
	    @Operation(summary = "Cria um novo recurso", description = "Este endpoint cria um novo recurso no sistema.")
	    public void post() {
	        //TODO
	    }

	    @PutMapping
	    @Operation(summary = "Atualiza um recurso existente", description = "Este endpoint atualiza um recurso existente com os dados fornecidos.")
	    public void put() {
	        //TODO
	    }

	    @DeleteMapping
	    @Operation(summary = "Remove um recurso", description = "Este endpoint exclui um recurso do sistema.")
	    public void delete() {
	        //TODO
	    }

	    @GetMapping("{id}")
	    @Operation(summary = "Busca um recurso por ID", description = "Este endpoint retorna os dados de um recurso específico com base no ID.")
	    public void get(@PathVariable String id) {
	        //TODO
	    }


}