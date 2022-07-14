package com.bci.prueba.tecnica.pruebatecnica.service;

import com.bci.prueba.tecnica.pruebatecnica.domain.request.UserRQ;
import com.bci.prueba.tecnica.pruebatecnica.domain.response.ProcessRS;
import com.bci.prueba.tecnica.pruebatecnica.domain.response.UserListRS;
import com.bci.prueba.tecnica.pruebatecnica.domain.response.UserRS;
import com.bci.prueba.tecnica.pruebatecnica.exceptions.UserException;

public interface UserService {

	UserListRS getAll() throws UserException;

	UserRS getByEmail(String email) throws UserException;

	UserRS getById(String id) throws UserException;

	ProcessRS save(UserRQ userRq) throws UserException;

	ProcessRS delete(String email);

	ProcessRS update(UserRQ userRq) throws UserException;

}
