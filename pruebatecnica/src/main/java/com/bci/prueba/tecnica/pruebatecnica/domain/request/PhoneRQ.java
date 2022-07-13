package com.bci.prueba.tecnica.pruebatecnica.domain.request;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PhoneRQ implements Serializable {

	private static final long serialVersionUID = 1789911423219500178L;

	@JsonProperty("number")
	private String number;
	
	@JsonProperty("citycode")
	private String cityCode;
	
	@JsonProperty("contrycode")
	private String contrycode;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getContrycode() {
		return contrycode;
	}

	public void setContrycode(String contrycode) {
		this.contrycode = contrycode;
	}

	@Override
	public String toString() {
		return "PhoneRQ [number=" + number + ", cityCode=" + cityCode + ", contrycode=" + contrycode + "]";
	}

}
