package com.bci.prueba.tecnica.pruebatecnica;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.bci.prueba.tecnica.pruebatecnica.model.User;
import com.bci.prueba.tecnica.pruebatecnica.repository.UserRepository;

@SpringBootApplication
public class PruebatecnicaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PruebatecnicaApplication.class, args);
	}

	@Bean
	CommandLineRunner demoData(UserRepository repo) {
		return args -> {
			User user = new User();
			user.setName("admin");
			user.setPassword("password");
			user.setEmail("admin@mail.com");
			repo.save(user);
		};
	}

}
