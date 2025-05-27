package br.com.cotiinformatica.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cotiinformatica.dtos.CategoriaResponseDto;
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
	@Autowired
	CategoriaRepository categoriaRepository;

	@Operation(summary = "Consulta de categorias", description = "Retorna todas as categorias cadastradas.")
	@GetMapping
	public List<CategoriaResponseDto> get() {

		var categorias = categoriaRepository.findAll(); // consultando no banco de dados

		var mapper = new ModelMapper(); // instanciando o model mapper

		// copiando os dados de cada categoria trazida do banco para a classe dto
		return categorias.stream().map(categoria -> mapper.map(categoria, CategoriaResponseDto.class))
				.collect(Collectors.toList());
	}
}
