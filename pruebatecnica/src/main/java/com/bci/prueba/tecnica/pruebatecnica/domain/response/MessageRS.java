package com.bci.prueba.tecnica.pruebatecnica.domain.response;

import java.io.Serializable;

public class MessageRS implements Serializable {

	private static final long serialVersionUID = -759013265017804193L;

	private String mensaje;

	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	@Override
	public String toString() {
		return "MessageRS [mensaje=" + mensaje + "]";
	}

}
