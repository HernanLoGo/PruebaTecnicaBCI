package com.bci.prueba.tecnica.pruebatecnica.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.bci.prueba.tecnica.pruebatecnica.domain.request.UserRQ;
import com.bci.prueba.tecnica.pruebatecnica.domain.response.ProcessRS;
import com.bci.prueba.tecnica.pruebatecnica.domain.response.UserListRS;
import com.bci.prueba.tecnica.pruebatecnica.domain.response.UserRS;
import com.bci.prueba.tecnica.pruebatecnica.exceptions.UserException;
import com.bci.prueba.tecnica.pruebatecnica.service.UserService;
import com.bci.prueba.tecnica.pruebatecnica.utils.Validations;

@Service
public class UserImpl implements UserService {

	private static final Logger log = LoggerFactory.getLogger(UserImpl.class);

	@Value("${password.patter.regex}")
	private String passworPattern;

	@Override
	public UserListRS getAll() {
		UserListRS userListRS = new UserListRS();
		List<UserRS> userList = new ArrayList<>();
		userList.add(new UserRS());
		userList.add(new UserRS());
		userListRS.setUsers(userList);

		return userListRS;
	}

	@Override
	public UserRS getByEmail(String email) {
		UserRS userRS = new UserRS();

		return userRS;
	}

	@Override
	public ProcessRS save(UserRQ user) throws UserException {
		ProcessRS processRS = new ProcessRS();
		
		//TODO: validar si existe correo electronico en db
		
		System.out.println("passworPattern: "+passworPattern);
		if(!Validations.isValidEmail(user.getEmail())) {
			log.error("Correo no valido");
			throw new UserException("Correo Eléctronico no válido");
		}
		
		if(!Validations.isValidPassword(user.getPassword(), passworPattern)) {
			log.error("Correo no valido");
			throw new UserException("Password ingresada debe ser de minismos 8 caracteres y contener letras mayusculas, minusculas, numeros y simbolos");
		}
		
		return processRS;
	}

	@Override
	public ProcessRS delete(String email) {
		ProcessRS processRS = new ProcessRS();
		return processRS;
	}

	@Override
	public ProcessRS update(UserRQ user) {
		ProcessRS processRS = new ProcessRS();
		return processRS;
	}
}
