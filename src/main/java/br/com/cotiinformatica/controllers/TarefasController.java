package br.com.cotiinformatica.controllers;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.cotiinformatica.components.JwtTokenComponent;
import br.com.cotiinformatica.domain.dtos.TarefaRequest;
import br.com.cotiinformatica.domain.dtos.TarefaResponse;
import br.com.cotiinformatica.domain.interfaces.TarefaService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/tarefas")
public class TarefasController {
	
	@Autowired TarefaService tarefaService;
	@Autowired JwtTokenComponent jwtTokenComponent;

	@PostMapping
	public ResponseEntity<TarefaResponse> post(
			@RequestBody @Valid TarefaRequest request,
			HttpServletRequest httpRequest
			) {		
		
		return ResponseEntity.ok(
				tarefaService.criar(request, jwtTokenComponent.getUser(httpRequest))
				);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<TarefaResponse> put(
			@PathVariable UUID id, 
			@RequestBody @Valid TarefaRequest request, 
			HttpServletRequest httpRequest) {
		
		return ResponseEntity.ok(
				tarefaService.alterar(id, request, jwtTokenComponent.getUser(httpRequest))
				);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<TarefaResponse> delete(
			@PathVariable UUID id, 
			HttpServletRequest httpRequest) {
		
		return ResponseEntity.ok(
				tarefaService.excluir(id, jwtTokenComponent.getUser(httpRequest))
				);
	}
	
	@GetMapping()
	public ResponseEntity<List<TarefaResponse>> getAll(
			@RequestParam(defaultValue = "2025-01-01T00:00") String dataMin,
			@RequestParam(defaultValue = "2025-01-31T23:59") String dataMax,
			HttpServletRequest httpRequest
		) {
		
		var dataHoraMin = LocalDateTime.parse(dataMin);
		var dataHoraMax = LocalDateTime.parse(dataMax);
		
		return ResponseEntity.ok(
				tarefaService.consultar(dataHoraMin, dataHoraMax, jwtTokenComponent.getUser(httpRequest))
				);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<TarefaResponse> getById(
			@PathVariable UUID id, 
			HttpServletRequest httpRequest) {
		
		return ResponseEntity.ok(
				tarefaService.obter(id, jwtTokenComponent.getUser(httpRequest))
				);
	}
}
