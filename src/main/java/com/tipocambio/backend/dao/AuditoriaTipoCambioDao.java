package com.tipocambio.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tipocambio.backend.entity.AuditoriaTipoCambio;

@Repository
public interface AuditoriaTipoCambioDao extends JpaRepository<AuditoriaTipoCambio, Integer> {

}
