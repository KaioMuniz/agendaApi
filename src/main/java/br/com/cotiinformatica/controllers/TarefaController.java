package br.com.cotiinformatica.controllers;

import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cotiinformatica.dtos.TarefaRequestDto;
import br.com.cotiinformatica.dtos.TarefaResponseDto;
import br.com.cotiinformatica.entities.Tarefa;
import br.com.cotiinformatica.repositories.CategoriaRepository;
import br.com.cotiinformatica.repositories.TarefaRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/tarefas")
@Tag(name = "Tarefas", description = "Serviço para operações relacionadas a tarefas.")
public class TarefaController {

	//Injeção de dependência (autoinicialização de um objeto)
	@Autowired TarefaRepository tarefaRepository;
	@Autowired CategoriaRepository categoriaRepository;
	@Autowired ModelMapper mapper;
	
	@Operation(summary = "Cadastro de tarefa", description = "Cria uma nova tarefa no banco de dados.")
	@PostMapping
	public TarefaResponseDto post(@RequestBody @Valid TarefaRequestDto request) {
		
		//buscar a categoria no banco de dados através do ID
		var categoria = categoriaRepository.findById(request.getCategoriaId())
							.orElseThrow(() -> new IllegalArgumentException("Categoria não encontrada. Verifique o ID informado."));
				
		var tarefa = mapper.map(request, Tarefa.class); //Copiar os dados do request DTO para a entidade
		tarefa.setId(UUID.randomUUID()); //gerando um ID para a tarefa
		tarefa.setCategoria(categoria); //associando a tarefa com a categoria
				
		//gravar a tarefa no banco de dados
		tarefaRepository.save(tarefa);
		
		//copiar os dados da tarefa cadastrada para a classe 'TarefaResponseDto'
		return mapper.map(tarefa, TarefaResponseDto.class);
	}

	@Operation(summary = "Edição de tarefa", description = "Atualiza os dados de uma tarefa no banco de dados.")
	@PutMapping("{id}")
	public TarefaResponseDto put(@PathVariable UUID id, @RequestBody @Valid TarefaRequestDto request) {
		// TODO Implementar o serviço para edição de tarefa
		return null;
	}

	@Operation(summary = "Exclusão de tarefa", description = "Exclui uma tarefa no banco de dados.")
	@DeleteMapping("{id}")
	public TarefaResponseDto delete(@PathVariable UUID id) {
		// TODO Implementar o serviço para exclusão de tarefa
		return null;
	}

	@Operation(summary = "Consulta de tarefas", description = "Retorna todas as tarefas cadastradas no banco de dados.")
	@GetMapping
	public List<TarefaResponseDto> get() {
		// TODO Implementar o serviço para consulta de tarefas
		return null;
	}
}
