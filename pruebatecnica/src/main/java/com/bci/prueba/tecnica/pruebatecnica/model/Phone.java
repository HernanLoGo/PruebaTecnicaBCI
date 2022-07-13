package com.bci.prueba.tecnica.pruebatecnica.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Phone implements Serializable {

	private static final long serialVersionUID = -7145926978638849317L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "number", length = 11, nullable = false)
	private Integer number;

	@Column(name = "citycode", length = 5, nullable = false)
	private Integer citycode;

	@Column(name = "countycode", length = 8, nullable = false)
	private Integer countycode;

	@ManyToOne
	@JoinColumn(name = "id", nullable = false)
	private User user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Integer getCitycode() {
		return citycode;
	}

	public void setCitycode(Integer citycode) {
		this.citycode = citycode;
	}

	public Integer getCountycode() {
		return countycode;
	}

	public void setCountycode(Integer countycode) {
		this.countycode = countycode;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Phone [id=" + id + ", number=" + number + ", citycode=" + citycode + ", countycode=" + countycode
				+ ", user=" + user + "]";
	}

}
