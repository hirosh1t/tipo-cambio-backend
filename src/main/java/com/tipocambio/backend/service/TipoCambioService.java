package com.tipocambio.backend.service;

import com.tipocambio.backend.dto.CambioDTO;
import com.tipocambio.backend.entity.AuditoriaTipoCambio;
import com.tipocambio.backend.entity.TipoCambio;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TipoCambioService {

	public TipoCambio saveTipoCambio(TipoCambio tipoCambio);
	
	public TipoCambio updateTipoCambio(TipoCambio tipoCambio);
	
	public TipoCambio findTipoCambio(String moneda);
	
	public AuditoriaTipoCambio resultadoTipoCambio(CambioDTO cambio);
	
}
