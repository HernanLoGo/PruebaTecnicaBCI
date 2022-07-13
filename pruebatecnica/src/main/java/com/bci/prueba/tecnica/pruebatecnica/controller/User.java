package com.bci.prueba.tecnica.pruebatecnica.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bci.prueba.tecnica.pruebatecnica.domain.request.UserRQ;
import com.bci.prueba.tecnica.pruebatecnica.domain.response.ProcessRS;
import com.bci.prueba.tecnica.pruebatecnica.domain.response.UserListRS;
import com.bci.prueba.tecnica.pruebatecnica.domain.response.UserRS;

@RestController
@RequestMapping("/usuario")
public class User {

	private static final Logger log = LoggerFactory.getLogger(User.class);

	@GetMapping(value = "/get-all", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserListRS> getAll() {
		log.info("[INIT][getAll]");

		ResponseEntity<UserListRS> response = null;
		UserListRS userListRS = new UserListRS();
		try {
			List<UserRS> userList = new ArrayList<>();
			userList.add(new UserRS());
			userList.add(new UserRS());
			userListRS.setUsers(userList);
			response = new ResponseEntity<>(userListRS, HttpStatus.OK);
		} catch (Exception e) {
			log.error(e.getMessage());
			userListRS.setMensaje("Error interno, intente más tarde");
			response = new ResponseEntity<>(userListRS, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		log.info("[END][getAll]");
		return response;
	}

	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserRS> getByEmail(@NotNull @NotBlank @RequestParam String email) {
		log.info("[INIT][getByEmail]");
		log.info("[PARAMS] " + email);

		ResponseEntity<UserRS> response = null;
		UserRS userRS = new UserRS();
		try {

			response = new ResponseEntity<>(userRS, HttpStatus.OK);
		} catch (Exception e) {
			log.error(e.getMessage());
			userRS.setMensaje("Error interno, intente más tarde");
			response = new ResponseEntity<>(userRS, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		log.info("[END][getByEmail]");
		return response;
	}

	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ProcessRS> save(@RequestBody UserRQ rq) {
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
		log.info("[END][insertUser]");
		return response;
	}

}
