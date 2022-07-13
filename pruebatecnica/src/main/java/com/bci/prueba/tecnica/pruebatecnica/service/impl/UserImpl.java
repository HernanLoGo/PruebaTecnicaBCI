package com.bci.prueba.tecnica.pruebatecnica.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.bci.prueba.tecnica.pruebatecnica.domain.response.ProcessRS;
import com.bci.prueba.tecnica.pruebatecnica.domain.response.UserListRS;
import com.bci.prueba.tecnica.pruebatecnica.domain.response.UserRS;
import com.bci.prueba.tecnica.pruebatecnica.service.UserService;

@Service
public class UserImpl implements UserService {

	private static final Logger log = LoggerFactory.getLogger(UserImpl.class);

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
	public UserRS getByEmail() {
		UserRS userRS = new UserRS();
		
		return userRS;
	}

	@Override
	public ProcessRS save() {
		ProcessRS processRS = new ProcessRS();
		return processRS;
	}

	@Override
	public ProcessRS delete() {
		ProcessRS processRS = new ProcessRS();
		return processRS;
	}

	@Override
	public ProcessRS update() {
		ProcessRS processRS = new ProcessRS();
		return processRS;
	}
}
