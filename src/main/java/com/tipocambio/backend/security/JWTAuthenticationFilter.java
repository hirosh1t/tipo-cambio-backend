package com.tipocambio.backend.security;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.tipocambio.backend.dto.AuthCredentialsDTO;
import com.tipocambio.backend.service.impl.UserDetailsImpl;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	private Gson gson = new Gson();
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request,
												HttpServletResponse response) {
		
		AuthCredentialsDTO authCredentials = new AuthCredentialsDTO();
		
		try {
			authCredentials = new ObjectMapper().readValue(request.getReader(), AuthCredentialsDTO.class);
		} catch (IOException e) {}
		
		UsernamePasswordAuthenticationToken usernamePAT = new UsernamePasswordAuthenticationToken(
				authCredentials.getEmail(),
				authCredentials.getPassword(),
				Collections.emptyList()
		);
		
		return getAuthenticationManager().authenticate(usernamePAT);
	}
	
	@Override
	protected void successfulAuthentication(HttpServletRequest request, 
											HttpServletResponse response, 
											FilterChain chain,
											Authentication authResult) throws IOException, ServletException {
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authResult.getPrincipal();
		String token = TokenUtils.createToken(userDetails.getNombre(), userDetails.getUsername());
		
		Map<String, String> result = new HashMap<>();
		result.put("Authorization", token);
		String resultString = this.gson.toJson(result);
		response.getWriter().print(resultString);
		response.getWriter().flush();
		
		super.successfulAuthentication(request, response, chain, authResult);
	}
	
}
