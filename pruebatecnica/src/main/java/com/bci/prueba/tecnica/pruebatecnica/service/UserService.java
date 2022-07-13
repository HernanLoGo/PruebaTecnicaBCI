package com.bci.prueba.tecnica.pruebatecnica.service;

import com.bci.prueba.tecnica.pruebatecnica.domain.request.UserRQ;
import com.bci.prueba.tecnica.pruebatecnica.domain.response.ProcessRS;
import com.bci.prueba.tecnica.pruebatecnica.domain.response.UserListRS;
import com.bci.prueba.tecnica.pruebatecnica.domain.response.UserRS;
import com.bci.prueba.tecnica.pruebatecnica.exceptions.UserException;

public interface UserService {

	UserListRS getAll();

	UserRS getByEmail(String email);

	ProcessRS save(UserRQ user) throws UserException;

	ProcessRS delete(String email);

	ProcessRS update(UserRQ user);

}
