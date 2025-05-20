package br.com.cotiinformatica.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cotiinformatica.entities.Categoria;
import br.com.cotiinformatica.repositories.CategoriaRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/categorias")
@Tag(name = "Categorias", description = "Serviço para operações relacionadas a categorias.")
public class CategoriaController {

	/*
	 * Injeção de dependência (autoinicialização de um objeto)
	 */
	@Autowired CategoriaRepository categoriaRepository;
	
	@Operation(summary = "Consulta de categorias", description = "Retorna todas as categorias cadastradas.")
	@GetMapping
	public List<Categoria> get() {		
		return categoriaRepository.findAll();
	}
}
