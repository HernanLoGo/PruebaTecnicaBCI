package com.bci.prueba.tecnica.pruebatecnica.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class DateUtils {

	private static final Logger log = LoggerFactory.getLogger(DateUtils.class);

	private DateUtils() {
		log.info("DateUtils");
	}

	public static final String localDateTimeToString(LocalDateTime date, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        String formatDateTime = date.format(formatter);
        return formatDateTime;
	}
	
	public static final LocalDateTime stringToLocalDateTime(String date, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        LocalDateTime formatDateTime = LocalDateTime.parse(date, formatter);
        return formatDateTime;
	}


}
