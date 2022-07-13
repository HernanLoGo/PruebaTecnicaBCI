package com.bci.prueba.tecnica.pruebatecnica.domain.request;


import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserRQ implements Serializable {

	private static final long serialVersionUID = -5407129093485289298L;

	@JsonProperty("name")
	private String name;
	
	@JsonProperty("email")
	private String email;
	
	@JsonProperty("password")
	private String password;
	
	@JsonProperty("phones")
	private List<PhoneRQ> phones;

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

	public List<PhoneRQ> getPhones() {
		return phones;
	}

	public void setPhones(List<PhoneRQ> phones) {
		this.phones = phones;
	}

	@Override
	public String toString() {
		return "UserRQ [name=" + name + ", email=" + email + ", password=" + password + ", phones=" + phones + "]";
	}

}
