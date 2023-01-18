package com.tipocambio.backend.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tipocambio.backend.entity.TipoCambio;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface TipoCambioDao extends JpaRepository<TipoCambio, Integer> {
	
	public Optional<TipoCambio> findOneByMonedaOrigen(String monedaOrigen);
	
	public Optional<TipoCambio> findOneByMonedaOrigenAndMonedaDestino(String monedaOrigen, String monedaDestino);

}
