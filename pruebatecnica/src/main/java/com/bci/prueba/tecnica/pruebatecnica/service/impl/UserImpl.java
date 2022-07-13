package com.bci.prueba.tecnica.pruebatecnica.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.bci.prueba.tecnica.pruebatecnica.domain.request.PhoneRQ;
import com.bci.prueba.tecnica.pruebatecnica.domain.request.UserRQ;
import com.bci.prueba.tecnica.pruebatecnica.domain.response.ProcessRS;
import com.bci.prueba.tecnica.pruebatecnica.domain.response.UserListRS;
import com.bci.prueba.tecnica.pruebatecnica.domain.response.UserRS;
import com.bci.prueba.tecnica.pruebatecnica.exceptions.UserException;
import com.bci.prueba.tecnica.pruebatecnica.model.Phone;
import com.bci.prueba.tecnica.pruebatecnica.model.User;
import com.bci.prueba.tecnica.pruebatecnica.repository.UserRepository;
import com.bci.prueba.tecnica.pruebatecnica.service.UserService;
import com.bci.prueba.tecnica.pruebatecnica.utils.Mapper;
import com.bci.prueba.tecnica.pruebatecnica.utils.Validations;

@Service
public class UserImpl implements UserService {

	private static final Logger log = LoggerFactory.getLogger(UserImpl.class);

	@Value("${password.patter.regex}")
	private String passworPattern;

	@Autowired
	private UserRepository userRepo;

	@Override
	public UserListRS getAll() throws UserException {

		List<User> userList = (List<User>) userRepo.findAll();

		if (userList.isEmpty()) {
			throw new UserException("No hay usuarios guardados");
		}

		return Mapper.userModelListToRS(userList);
	}

	@Override
	public UserRS getByEmail(String email) throws UserException {
		Optional<User> user = userRepo.findByEmail(email);

		if (!user.isPresent()) {
			throw new UserException("Usuario con email: " + email + " no encontrado");
		}

		return Mapper.userModelToRS(user.get());
	}

	@Override
	public ProcessRS save(UserRQ userRq) throws UserException {
		ProcessRS processRS = new ProcessRS();

		// TODO: validar si existe correo electronico en db

		System.out.println("passworPattern: " + passworPattern);
		if (!Validations.isValidEmail(userRq.getEmail())) {
			log.error("Correo no valido");
			throw new UserException("Correo Eléctronico no válido");
		}

		if (!Validations.isValidPassword(userRq.getPassword(), passworPattern)) {
			log.error("Correo no valido");
			throw new UserException(
					"Password ingresada debe ser de minismos 8 caracteres y contener letras mayusculas, minusculas, numeros y simbolos");
		}

		User user = userRepo.save(Mapper.userRsToModel(userRq));

		return processRS;
	}

	@Override
	public ProcessRS delete(String email) {
		ProcessRS processRS = new ProcessRS();
		return processRS;
	}

	@Override
	public ProcessRS update(UserRQ userRq) {
		ProcessRS processRS = new ProcessRS();
		return processRS;
	}
}
