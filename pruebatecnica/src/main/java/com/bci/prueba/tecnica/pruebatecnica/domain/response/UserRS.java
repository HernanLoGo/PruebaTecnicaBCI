package com.bci.prueba.tecnica.pruebatecnica.domain.response;

import java.io.Serializable;
import java.util.List;

public class UserRS implements Serializable {

	private static final long serialVersionUID = -278740314355649034L;
	
	private String name;
	private String email;
	private String password;
	private List<PhoneRS> phones;

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

	@Override
	public String toString() {
		return "UserRQ [name=" + name + ", email=" + email + ", password=" + password + ", phones=" + phones + "]";
	}

}