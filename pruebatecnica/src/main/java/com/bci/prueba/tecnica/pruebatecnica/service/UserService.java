package com.bci.prueba.tecnica.pruebatecnica.service;

import com.bci.prueba.tecnica.pruebatecnica.domain.response.ProcessRS;
import com.bci.prueba.tecnica.pruebatecnica.domain.response.UserListRS;
import com.bci.prueba.tecnica.pruebatecnica.domain.response.UserRS;

public interface UserService {

	UserListRS getAll();

	UserRS getByEmail();

	ProcessRS save();

	ProcessRS delete();

	ProcessRS update();

}
