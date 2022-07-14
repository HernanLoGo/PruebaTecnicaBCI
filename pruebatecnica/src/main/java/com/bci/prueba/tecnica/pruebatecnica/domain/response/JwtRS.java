package com.bci.prueba.tecnica.pruebatecnica.domain.response;

import java.io.Serializable;

public class JwtRS implements Serializable {

	private static final long serialVersionUID = -8091879091924046844L;
	private final String jwttoken;

	public JwtRS(String jwttoken) {
		this.jwttoken = jwttoken;
	}

	public String getToken() {
		return this.jwttoken;
	}
}