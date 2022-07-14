package com.bci.prueba.tecnica.pruebatecnica.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.springframework.data.annotation.Persistent;

@Entity
@Persistent
@Table(name = "Properties")
public class Details implements Serializable {

	private static final long serialVersionUID = 6464250997724598471L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idDetails", updatable = false, nullable = false, unique = true)
	@Type(type = "uuid-char")
	private UUID idDetails;

	private LocalDateTime created;

	private LocalDateTime modified;

	private LocalDateTime lastLogin;

	private boolean isActive;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "idUser")
	private User user;

	public UUID getIdDetails() {
		return idDetails;
	}

	public void setIdDetails(UUID idDetails) {
		this.idDetails = idDetails;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public LocalDateTime getModified() {
		return modified;
	}

	public void setModified(LocalDateTime modified) {
		this.modified = modified;
	}

	public LocalDateTime getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(LocalDateTime lastLogin) {
		this.lastLogin = lastLogin;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Details [idDetails=" + idDetails + ", created=" + created + ", modified=" + modified + ", lastLogin="
				+ lastLogin + ", isActive=" + isActive + ", user=" + user + ", getIdDetails()=" + getIdDetails()
				+ ", getCreated()=" + getCreated() + ", getModified()=" + getModified() + ", getLastLogin()="
				+ getLastLogin() + ", isActive()=" + isActive() + ", getUser()=" + getUser() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
