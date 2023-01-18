package com.tipocambio.backend.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class CambioDTO {
	
	private BigDecimal monto;
	
	private String monedaOrigen;
	
	private String monedaDestino;

}
