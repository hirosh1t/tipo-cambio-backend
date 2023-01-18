package com.tipocambio.backend.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tipocambio.backend.entity.Usuario;

public interface UsuarioDao extends JpaRepository<Usuario, Integer> {

	Optional<Usuario> findOneByEmail(String email);
	
}
