package com.bci.prueba.tecnica.pruebatecnica.domain.response;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class UserListRS implements Serializable {

	private static final long serialVersionUID = -6745161282816496249L;

	private List<UserRS> users;
	private String mensaje;

	public UserListRS() {
		super();
	}

	public UserListRS(String mensaje) {
		super();
		this.mensaje = mensaje;
	}

	public List<UserRS> getUsers() {
		return users;
	}

	public void setUsers(List<UserRS> users) {
		this.users = users;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	@Override
	public String toString() {
		return "UsersRS [users=" + users + ", mensaje=" + mensaje + "]";
	}

}
