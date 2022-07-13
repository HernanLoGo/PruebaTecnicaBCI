package com.bci.prueba.tecnica.pruebatecnica.domain.response;

import java.io.Serializable;

public class PhoneRS implements Serializable {

	private static final long serialVersionUID = 885803878845597422L;
	
	private String number;
	private String cityCode;
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
