package br.com.cotiinformatica.domain.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cotiinformatica.domain.dtos.TarefaRequest;
import br.com.cotiinformatica.domain.dtos.TarefaResponse;
import br.com.cotiinformatica.domain.entities.Tarefa;
import br.com.cotiinformatica.domain.interfaces.TarefaService;
import br.com.cotiinformatica.repositories.TarefaRepository;

@Service
public class TarefaServiceImpl implements TarefaService {

	@Autowired TarefaRepository tarefaRepository;
	@Autowired ModelMapper modelMapper;
	
	@Override
	public TarefaResponse criar(TarefaRequest request, UUID usuarioId) {

		var tarefa = modelMapper.map(request, Tarefa.class);
		tarefa.setUsuarioId(usuarioId);
		
		tarefaRepository.save(tarefa);
		
		return modelMapper.map(tarefa, TarefaResponse.class);
	}

	@Override
	public TarefaResponse alterar(UUID id, TarefaRequest request, UUID usuarioId) {

		var tarefa = tarefaRepository.findByIdAndUsuarioId(id, usuarioId)
						.orElseThrow(() -> new IllegalArgumentException("Tarefa não encontrada."));
		
		modelMapper.map(request, tarefa);
		
		tarefaRepository.save(tarefa);
		
		return modelMapper.map(tarefa, TarefaResponse.class);
	}

	@Override
	public TarefaResponse excluir(UUID id, UUID usuarioId) {
		
		var tarefa = tarefaRepository.findByIdAndUsuarioId(id, usuarioId)
				.orElseThrow(() -> new IllegalArgumentException("Tarefa não encontrada."));
		
		tarefaRepository.delete(tarefa);
		
		return modelMapper.map(tarefa, TarefaResponse.class);
	}

	@Override
	public List<TarefaResponse> consultar(LocalDateTime datMin, LocalDateTime dataMax, UUID usuarioId) {
		
		var tarefas = tarefaRepository.findByUsuarioIdAndDataHoraBetween(usuarioId, datMin, dataMax);
		
		return tarefas.stream()
				.map(tarefa -> modelMapper.map(tarefa, TarefaResponse.class))
				.collect(Collectors.toList());
	}

	@Override
	public TarefaResponse obter(UUID id, UUID usuarioId) {

		var tarefa = tarefaRepository.findByIdAndUsuarioId(id, usuarioId)
				.orElseThrow(() -> new IllegalArgumentException("Tarefa não encontrada."));
		
		return modelMapper.map(tarefa, TarefaResponse.class);
	}

}
