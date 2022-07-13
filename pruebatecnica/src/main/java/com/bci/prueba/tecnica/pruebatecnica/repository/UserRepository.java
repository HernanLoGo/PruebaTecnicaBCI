package com.bci.prueba.tecnica.pruebatecnica.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.bci.prueba.tecnica.pruebatecnica.model.User;

public interface UserRepository extends CrudRepository<User, UUID>{

}
