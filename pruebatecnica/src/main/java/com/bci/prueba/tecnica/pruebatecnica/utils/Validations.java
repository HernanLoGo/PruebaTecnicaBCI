package com.bci.prueba.tecnica.pruebatecnica.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class Validations {

	private static final Logger log = LoggerFactory.getLogger(Validations.class);

	private Validations() {
		log.info("Constantes Creadas");
	}

	public static final boolean isValidEmail(String email) {
		Pattern pattern = Pattern.compile(Constant.EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}

	public static boolean isValidPassword(String password, String passworPattern) {
		Pattern pattern = Pattern.compile(passworPattern);
		Matcher matcher = pattern.matcher(password);
		return matcher.matches();
	}

}
