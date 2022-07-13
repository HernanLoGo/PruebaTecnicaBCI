package com.bci.prueba.tecnica.pruebatecnica.domain.response;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class ProcessRS implements Serializable {

	private static final long serialVersionUID = 8597016191852498770L;

	@JsonProperty("id")
	private String id;
	
	@JsonProperty("created")
	private String created;
	
	@JsonProperty("modified")
	private String modified;
	
	@JsonProperty("last_login")
	private String lastlogin;
	
	@JsonProperty("token")
	private String token;
	
	@JsonProperty("isActive")
	private String isActive;
	
	@JsonProperty("mensaje")
	private MessageRS mensaje;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getModified() {
		return modified;
	}

	public void setModified(String modified) {
		this.modified = modified;
	}

	public String getLastlogin() {
		return lastlogin;
	}

	public void setLastlogin(String lastlogin) {
		this.lastlogin = lastlogin;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public MessageRS getMensaje() {
		return mensaje;
	}

	public void setMensaje(MessageRS mensaje) {
		this.mensaje = mensaje;
	}

	@Override
	public String toString() {
		return "ProcessRS [id=" + id + ", created=" + created + ", modified=" + modified + ", lastlogin=" + lastlogin
				+ ", token=" + token + ", isActive=" + isActive + ", mensaje=" + mensaje + "]";
	}

}
