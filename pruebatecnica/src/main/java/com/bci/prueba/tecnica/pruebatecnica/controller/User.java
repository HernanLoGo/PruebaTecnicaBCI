package com.bci.prueba.tecnica.pruebatecnica.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/usuario")
public class User {
	
	@GetMapping
	public ResponseEntity<String> getTestData() {
		System.out.println("ssss");
		return new ResponseEntity<>("hola",HttpStatus.OK);
	}

}
