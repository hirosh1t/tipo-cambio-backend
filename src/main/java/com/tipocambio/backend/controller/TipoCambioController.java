package com.tipocambio.backend.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tipocambio.backend.dto.CambioDTO;
import com.tipocambio.backend.entity.AuditoriaTipoCambio;
import com.tipocambio.backend.entity.TipoCambio;
import com.tipocambio.backend.service.TipoCambioService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path = "/tipo-cambio")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class TipoCambioController {
	
	private final TipoCambioService tipoCambioService;
	
	@GetMapping(value = "/find-moneda", produces = { MediaType.APPLICATION_JSON_VALUE })
	public TipoCambio findTipoCambio(@RequestParam(name = "moneda", required = true) String moneda) {
		return tipoCambioService.findTipoCambio(moneda);
	}
	
	@PostMapping(value = "/save", produces = { MediaType.APPLICATION_JSON_VALUE })
	public TipoCambio saveTipoCambio(@RequestBody TipoCambio tipoCambio) {
		return tipoCambioService.saveTipoCambio(tipoCambio);
	}
	
	@PutMapping(value = "/update", produces = { MediaType.APPLICATION_JSON_VALUE })
	public TipoCambio updateTipoCambio(@RequestBody TipoCambio tipoCambio) {
		return tipoCambioService.updateTipoCambio(tipoCambio);
	}
	
	@PostMapping(value = "/resultado-tipo-cambio", produces = { MediaType.APPLICATION_JSON_VALUE })
	public AuditoriaTipoCambio resultadoTipoCambio(@RequestBody CambioDTO cambioDTO) {
		return tipoCambioService.resultadoTipoCambio(cambioDTO);
	}

}
