package br.com.cotiinformatica.controllers;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
		
		//verificar se a tarefa não existe no banco de dados (através do id informado)
		if(!tarefaRepository.existsById(id))
			throw new IllegalArgumentException("Tarefa não encontrado. Verifique o ID informado.");
		
		//buscar a categoria no banco de dados através do ID
		var categoria = categoriaRepository.findById(request.getCategoriaId())
							.orElseThrow(() -> new IllegalArgumentException("Categoria não encontrada. Verifique o ID informado."));
		
		//copiar os dados do request para a entidade
		var tarefa = mapper.map(request, Tarefa.class);
		tarefa.setId(id); //capturando o id enviado da tarefa
		tarefa.setCategoria(categoria); //associando a tarefa com a categoria
		
		//atualizando a tarefa no banco de dados
		tarefaRepository.save(tarefa);
		
		//copiar os dados da tarefa cadastrada para a classe 'TarefaResponseDto'
		return mapper.map(tarefa, TarefaResponseDto.class);
	}

	@Operation(summary = "Exclusão de tarefa", description = "Exclui uma tarefa no banco de dados.")
	@DeleteMapping("{id}")
	public TarefaResponseDto delete(@PathVariable UUID id) {

		//buscar a tarefa no banco de dados através do ID
		var tarefa = tarefaRepository.findById(id)
						.orElseThrow(() -> new IllegalArgumentException("Tarefa não encontrado. Verifique o ID informado."));
		
		//excluindo a tarefa
		tarefaRepository.delete(tarefa);		
		
		//copiar os dados da tarefa cadastrada para a classe 'TarefaResponseDto'
		return mapper.map(tarefa, TarefaResponseDto.class);
	}

	
	@Operation(summary = "Consulta de tarefas", description = "Retorna todas as tarefas cadastradas no banco de dados.")
	@GetMapping("{dataMin}/{dataMax}")
	public List<TarefaResponseDto> get(
			@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataMin,
			@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataMax
			) {
		
		var inicio = dataMin.atStartOfDay(); //A primeira data deve ficar com a hora 00:00:00
		var fim = dataMax.atTime(LocalTime.MAX); //A ultima data deve ficar com a hora 23:59:59
		
		//converter para o padrão Date (java.util)
		var dataInicio = Date.from(inicio.atZone(ZoneId.systemDefault()).toInstant());
		var dataFim = Date.from(fim.atZone(ZoneId.systemDefault()).toInstant());
		
		//consultando as tarefas no banco de dados
		var tarefas = tarefaRepository.findByDatas(dataInicio, dataFim);
		
		//usando o modelmapper para copiar os dados da lista de tarefas para a lista de TarefaResponseDto
		return tarefas.stream()
				.map(tarefa -> mapper.map(tarefa, TarefaResponseDto.class))
				.collect(Collectors.toList());
	}
	
	@Operation(summary = "Consulta de tarefa por Id", description = "Retorna os dados de 1 tarefa do banco de dados.")
	@GetMapping("{id}")
	public TarefaResponseDto get(@PathVariable UUID id) {
		
		//buscar a tarefa no banco de dados através do ID
		var tarefa = tarefaRepository.findById(id)
						.orElseThrow(() -> new IllegalArgumentException("Tarefa não encontrado. Verifique o ID informado."));
		
		//copiar os dados da tarefa cadastrada para a classe 'TarefaResponseDto'
		return mapper.map(tarefa, TarefaResponseDto.class);
	}

}
