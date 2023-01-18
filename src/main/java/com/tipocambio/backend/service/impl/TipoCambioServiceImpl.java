package com.tipocambio.backend.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tipocambio.backend.dao.AuditoriaTipoCambioDao;
import com.tipocambio.backend.dao.TipoCambioDao;
import com.tipocambio.backend.dto.CambioDTO;
import com.tipocambio.backend.entity.AuditoriaTipoCambio;
import com.tipocambio.backend.entity.TipoCambio;
import com.tipocambio.backend.service.TipoCambioService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Service
@Transactional
@RequiredArgsConstructor
public class TipoCambioServiceImpl implements TipoCambioService {

	private final TipoCambioDao tipoCambioDao;

	private final AuditoriaTipoCambioDao auditoriaTipoCambioDao;

	@Override
	public TipoCambio saveTipoCambio(TipoCambio tipoCambio) {
		tipoCambio.setTipoCambioId(null);
		return tipoCambioDao.save(tipoCambio);
	}

	@Override
	public TipoCambio updateTipoCambio(TipoCambio tipoCambio) {
		return tipoCambioDao.save(tipoCambio);
	}

	@Override
	public TipoCambio findTipoCambio(String moneda) {
		Optional<TipoCambio> tipoCambio = tipoCambioDao.findOneByMonedaOrigen(moneda);
		if(tipoCambio.isPresent()) {
			return tipoCambio.get();
		} else {
			return null;
		}
	}

	@Override
	public AuditoriaTipoCambio resultadoTipoCambio(CambioDTO cambio) {
		Optional<TipoCambio> tipoCambio = tipoCambioDao.findOneByMonedaOrigenAndMonedaDestino(cambio.getMonedaOrigen(), cambio.getMonedaDestino());
		if(tipoCambio.isPresent()) {
			AuditoriaTipoCambio result = AuditoriaTipoCambio.builder().monto(cambio.getMonto())
					  .monedaOrigen(tipoCambio.get().getMonedaOrigen())
					  .monedaDestino(tipoCambio.get().getMonedaDestino())
					  .montoTotal(cambio.getMonto().multiply(tipoCambio.get().getMonto()))
					  .tipoCambio(tipoCambio.get().getMonto()).build();
			return auditoriaTipoCambioDao.save(result);
		} else {
			return null;
		}
	}

}
