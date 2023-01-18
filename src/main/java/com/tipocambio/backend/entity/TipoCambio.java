package com.tipocambio.backend.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "TIPO_CAMBIO")
@Data
public class TipoCambio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer tipoCambioId;
	
	@Column(nullable=false, length=10)
	private String monedaOrigen;
	
	@Column(nullable=false, length=10)
	private String monedaDestino;
	
	@Column(nullable=false, precision=10, scale=2)
	private BigDecimal monto;

}
