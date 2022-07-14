package com.bci.prueba.tecnica.pruebatecnica.model;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.springframework.data.annotation.Persistent;

@Entity
@Persistent
@Table(name = "Phones")
public class Phone implements Serializable {

	private static final long serialVersionUID = -7145926978638849317L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idPhone", updatable = false, nullable = false, unique = true)
	@Type(type = "uuid-char")
	private UUID idPhone;

	@Column(name = "number", length = 11, nullable = false)
	private String number;

	@Column(name = "citycode", length = 5, nullable = false)
	private String citycode;

	@Column(name = "contrycode", length = 8, nullable = false)
	private String contrycode;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "idUser")
	private User user;

	public UUID getIdPhone() {
		return idPhone;
	}

	public void setIdPhone(UUID idPhone) {
		this.idPhone = idPhone;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getCitycode() {
		return citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public String getContrycode() {
		return contrycode;
	}

	public void setContrycode(String contrycode) {
		this.contrycode = contrycode;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Phone [number=" + number + ", citycode=" + citycode + ", contrycode=" + contrycode + ", user=" + user
				+ "]";
	}

}
