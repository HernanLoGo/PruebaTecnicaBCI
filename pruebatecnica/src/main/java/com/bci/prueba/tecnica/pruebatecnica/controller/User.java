package com.bci.prueba.tecnica.pruebatecnica.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bci.prueba.tecnica.pruebatecnica.domain.request.UserRQ;
import com.bci.prueba.tecnica.pruebatecnica.domain.response.ProcessRS;

@RestController
@RequestMapping(value = "/usuario")
public class User {
	
	//TODO: borrar MessageRS

	private static final Logger log = LoggerFactory.getLogger(User.class);

	@GetMapping
	public ResponseEntity<String> getTestData() {
		System.out.println("ssss");
		return new ResponseEntity<>("hola", HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<ProcessRS> insertUser(@RequestBody UserRQ rq) {
		log.info("[INIT][insertUser]");
		log.info("[PARAMS] " + rq);

		ResponseEntity<ProcessRS> response = null;
		ProcessRS processRS = new ProcessRS();
		try {
			
			response = new ResponseEntity<>(processRS, HttpStatus.OK);
		} catch (Exception e) {
			log.error(e.getMessage());
			processRS.setMensaje("Error interno, intente más tarde");
			response = new ResponseEntity<>(processRS, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

}
