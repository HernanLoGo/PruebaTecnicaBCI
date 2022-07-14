package com.bci.prueba.tecnica.pruebatecnica.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.bci.prueba.tecnica.pruebatecnica.domain.request.UserRQ;
import com.bci.prueba.tecnica.pruebatecnica.domain.response.ProcessRS;
import com.bci.prueba.tecnica.pruebatecnica.domain.response.UserListRS;
import com.bci.prueba.tecnica.pruebatecnica.domain.response.UserRS;
import com.bci.prueba.tecnica.pruebatecnica.exceptions.UserException;
import com.bci.prueba.tecnica.pruebatecnica.model.Details;
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
	public UserRS getById(String id) throws UserException {
		Optional<User> user = getUserById(id);

		return Mapper.userModelToRS(user.get());
	}

	@Override
	public ProcessRS save(UserRQ userRq) throws UserException {
		validatedEmailExists(userRq);

		validateEmailPasswordFormat(userRq);

		User userToSave = Mapper.userRsToModel(userRq);

		LocalDateTime currentDate = LocalDateTime.now();
		Details details = new Details();
		details.setActive(Boolean.TRUE);
		details.setCreated(currentDate);
		details.setLastLogin(currentDate);
		details.setModified(null);
		details.setUser(userToSave);
		userToSave.setDetails(details);

		User user = userRepo.save(userToSave);

		return Mapper.detailsModelToProcess(user.getDetails(),  "Usuario actualizado con exito");
	}

	@Override
	public ProcessRS delete(String id) throws UserException {
		
		User userToDelete = getUserById(id).get();
		
		userToDelete.getDetails().setActive(Boolean.FALSE);

		return Mapper.detailsModelToProcess(userToDelete.getDetails(), "Usuario eliminado con exito");
	}

	@Override
	public ProcessRS update(UserRQ userRq) throws UserException {
		Optional<User> userFromDB = getUserById(userRq.getId());

		Optional<User> userEmail = userRepo.findByEmail(userRq.getEmail());
		if (userEmail.isPresent() && userEmail.get().getIdUser().compareTo(userFromDB.get().getIdUser())!=0) {
			throw new UserException("El correo ya está registrado");
		}

		validateEmailPasswordFormat(userRq);

		User userToUpdate = Mapper.userRsToModel(userRq);
		userToUpdate.setIdUser(userFromDB.get().getIdUser());

		LocalDateTime currentDate = LocalDateTime.now();
		userToUpdate.setDetails(userFromDB.get().getDetails());
		userToUpdate.getDetails().setModified(currentDate);
		userToUpdate.getDetails().setUser(userToUpdate);

		userRepo.save(userToUpdate);

		return Mapper.detailsModelToProcess(userToUpdate.getDetails(), "Usuario actualizado con exito");
	}

	private Optional<User> getUserById(String id) throws UserException {
		Optional<User> user = userRepo.findById(UUID.fromString(id));
		if (!user.isPresent()) {
			throw new UserException("Usuario con id: " + id + " no encontrado");
		}
		return user;
	}

	private void validatedEmailExists(UserRQ userRq) throws UserException {
		Optional<User> userEmail = userRepo.findByEmail(userRq.getEmail());
		if (userEmail.isPresent()) {
			throw new UserException("El correo ya está registrado");
		}
	}

	private void validateEmailPasswordFormat(UserRQ userRq) throws UserException {
		if (!Validations.isValidEmail(userRq.getEmail())) {
			log.error("Correo no valido");
			throw new UserException("Correo Eléctronico no válido");
		}

		if (!Validations.isValidPassword(userRq.getPassword(), passworPattern)) {
			log.error("Correo no valido");
			throw new UserException(
					"Password ingresada debe ser de minismos 8 caracteres y contener letras mayusculas, minusculas, numeros y simbolos");
		}
	}
}
