package com.bci.prueba.tecnica.pruebatecnica.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.Persistent;

//@Entity
//@Persistent
//@Table(name = "User")
public class Properties implements Serializable {

	private static final long serialVersionUID = 6464250997724598471L;

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idContacto;

	private LocalDateTime created;

	private LocalDateTime modified;

	private LocalDateTime lastLogin;

	private boolean isActive;

//	@Column(name = "name", nullable = false)
//	@OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "id")
	private User user;

	public Integer getIdContacto() {
		return idContacto;
	}

	public void setIdContacto(Integer idContacto) {
		this.idContacto = idContacto;
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
		return "Properties [idContacto=" + idContacto + ", created=" + created + ", modified=" + modified
				+ ", lastLogin=" + lastLogin + ", isActive=" + isActive + ", user=" + user + "]";
	}

}
