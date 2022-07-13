package com.bci.prueba.tecnica.pruebatecnica.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class Constant {

	private static final Logger log = LoggerFactory.getLogger(Constant.class);

	public static final String ERROR_INTERNO_DEFAULT = "Error interno, intente más tarde";

	public static final String EMAIL_PATTERN = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    
	private Constant() {
		log.info("Constantes Creadas");
	}

}
