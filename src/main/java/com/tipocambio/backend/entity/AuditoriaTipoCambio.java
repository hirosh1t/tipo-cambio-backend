package com.tipocambio.backend.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "AUDITORIA_TIPO_CAMBIO")
@Data
@Builder
public class AuditoriaTipoCambio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer auditoriaTipoCambioId;
	
	@Column(nullable=false, precision=10, scale=2)
	private BigDecimal monto;
	
	@Column(nullable=false, length=10)
	private String monedaOrigen;
	
	@Column(nullable=false, length=10)
	private String monedaDestino;
	
	@Column(nullable=false, precision=10, scale=2)
	private BigDecimal montoTotal;
	
	@Column(nullable=false, precision=10, scale=2)
	private BigDecimal tipoCambio;
	
}
