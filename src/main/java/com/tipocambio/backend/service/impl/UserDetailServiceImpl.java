package com.tipocambio.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tipocambio.backend.dao.UsuarioDao;
import com.tipocambio.backend.entity.Usuario;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioDao usuarioDao;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuario usuario = usuarioDao
			.findOneByEmail(email)
			.orElseThrow(() -> new UsernameNotFoundException("El usuario con email" + email + "no existe."));
		return new UserDetailsImpl(usuario);
	}

}
