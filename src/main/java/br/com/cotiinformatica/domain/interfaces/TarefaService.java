package br.com.cotiinformatica.domain.interfaces;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import br.com.cotiinformatica.domain.dtos.TarefaRequest;
import br.com.cotiinformatica.domain.dtos.TarefaResponse;

public interface TarefaService {

	TarefaResponse criar(TarefaRequest request, UUID usuarioId);
	
	TarefaResponse alterar(UUID id, TarefaRequest request, UUID usuarioId);
	
	TarefaResponse excluir(UUID id, UUID usuarioId);
	
	List<TarefaResponse> consultar(LocalDateTime datMin, LocalDateTime dataMax, UUID usuarioId);
	
	TarefaResponse obter(UUID id, UUID usuarioId);
}
