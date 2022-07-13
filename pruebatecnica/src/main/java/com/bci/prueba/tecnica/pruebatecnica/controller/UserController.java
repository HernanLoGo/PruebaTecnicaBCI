package com.bci.prueba.tecnica.pruebatecnica.controller;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bci.prueba.tecnica.pruebatecnica.domain.request.UserRQ;
import com.bci.prueba.tecnica.pruebatecnica.domain.response.ProcessRS;
import com.bci.prueba.tecnica.pruebatecnica.domain.response.UserListRS;
import com.bci.prueba.tecnica.pruebatecnica.domain.response.UserRS;
import com.bci.prueba.tecnica.pruebatecnica.exceptions.UserException;
import com.bci.prueba.tecnica.pruebatecnica.service.UserService;
import com.bci.prueba.tecnica.pruebatecnica.utils.Constant;

@RestController
@RequestMapping("/usuario")
public class UserController {

	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userSvc;

	@GetMapping(value = "/get-all", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserListRS> getAll() {
		log.info("[INIT][getAll]");

		ResponseEntity<UserListRS> response = null;
		UserListRS userListRS = null;
		try {
			userListRS = userSvc.getAll();
			response = new ResponseEntity<>(userListRS, HttpStatus.OK);
		
		} catch (Exception e) {
			log.error(e.getMessage());
			userListRS = new UserListRS(Constant.ERROR_INTERNO_DEFAULT);
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
		UserRS userRS = null;
		try {
			userRS = userSvc.getByEmail(email);
			response = new ResponseEntity<>(userRS, HttpStatus.OK);
		} catch (Exception e) {
			log.error(e.getMessage());
			userRS = new UserRS(Constant.ERROR_INTERNO_DEFAULT);
			response = new ResponseEntity<>(userRS, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		log.info("[END][getByEmail]");
		return response;
	}

	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ProcessRS> save(@RequestBody UserRQ rq) {
		log.info("[INIT][save]");
		log.info("[PARAMS] " + rq);

		ResponseEntity<ProcessRS> response = null;
		ProcessRS processRS = null;
		try {
			processRS = userSvc.save(rq);
			response = new ResponseEntity<>(processRS, HttpStatus.OK);
		}catch (UserException e) {
			log.error(e.getMessage());
			processRS = new ProcessRS(e.getMessage());
			response = new ResponseEntity<>(processRS, HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			log.error(e.getMessage());
			processRS = new ProcessRS(Constant.ERROR_INTERNO_DEFAULT);
			response = new ResponseEntity<>(processRS, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		log.info("[END][save]");
		return response;
	}

	@DeleteMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ProcessRS> delete(@NotNull @NotBlank @RequestParam String email) {
		log.info("[INIT][delete]");
		log.info("[PARAMS] " + email);

		ResponseEntity<ProcessRS> response = null;
		ProcessRS processRS = null;
		try {
			processRS = userSvc.delete(email);
			response = new ResponseEntity<>(processRS, HttpStatus.OK);
		} catch (Exception e) {
			log.error(e.getMessage());
			processRS = new ProcessRS(Constant.ERROR_INTERNO_DEFAULT);
			response = new ResponseEntity<>(processRS, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		log.info("[END][delete]");
		return response;
	}

	@PutMapping(consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ProcessRS> update(@RequestBody UserRQ rq) {
		log.info("[INIT][update]");
		log.info("[PARAMS] " + rq);

		ResponseEntity<ProcessRS> response = null;
		ProcessRS processRS = null;
		try {
			processRS = userSvc.update(rq);
			response = new ResponseEntity<>(processRS, HttpStatus.OK);
		} catch (Exception e) {
			log.error(e.getMessage());
			processRS = new ProcessRS(Constant.ERROR_INTERNO_DEFAULT);
			response = new ResponseEntity<>(processRS, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		log.info("[END][update]");
		return response;
	}
}
