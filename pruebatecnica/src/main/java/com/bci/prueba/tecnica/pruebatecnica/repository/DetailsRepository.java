package com.bci.prueba.tecnica.pruebatecnica.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.bci.prueba.tecnica.pruebatecnica.model.Details;
import com.bci.prueba.tecnica.pruebatecnica.model.User;

public interface DetailsRepository extends CrudRepository<Details, Long>{

	
}
