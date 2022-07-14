package com.bci.prueba.tecnica.pruebatecnica.domain.response;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class UserRS implements Serializable {

	private static final long serialVersionUID = -278740314355649034L;

	private String id;
	private String name;
	private String email;
	private String password;
	private List<PhoneRS> phones;
	private String mensaje;

	public UserRS() {
		super();
	}

	public UserRS(String mensaje) {
		super();
		this.mensaje = mensaje;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<PhoneRS> getPhones() {
		return phones;
	}

	public void setPhones(List<PhoneRS> phones) {
		this.phones = phones;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	@Override
	public String toString() {
		return "UserRS [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", phones="
				+ phones + ", mensaje=" + mensaje + "]";
	}

}
