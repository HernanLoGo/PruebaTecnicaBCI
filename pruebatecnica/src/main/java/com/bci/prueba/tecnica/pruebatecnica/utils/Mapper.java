package com.bci.prueba.tecnica.pruebatecnica.utils;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bci.prueba.tecnica.pruebatecnica.domain.request.PhoneRQ;
import com.bci.prueba.tecnica.pruebatecnica.domain.request.UserRQ;
import com.bci.prueba.tecnica.pruebatecnica.domain.response.PhoneRS;
import com.bci.prueba.tecnica.pruebatecnica.domain.response.UserListRS;
import com.bci.prueba.tecnica.pruebatecnica.domain.response.UserRS;
import com.bci.prueba.tecnica.pruebatecnica.model.Phone;
import com.bci.prueba.tecnica.pruebatecnica.model.User;

public final class Mapper {

	private static final Logger log = LoggerFactory.getLogger(Mapper.class);

	private Mapper() {
		log.info("Constantes Creadas");
	}

	public static User userRsToModel(UserRQ rq) {
		User user = new User();

		user.setEmail(rq.getEmail());
		user.setName(rq.getName());
		user.setPassword(rq.getPassword());

		user.setPhones(phoneRqToModel(rq.getPhones(), user));

		return user;
	}

	public static List<Phone> phoneRqToModel(List<PhoneRQ> phones, User user) {
		List<Phone> phoneList = new ArrayList<>();
		for (PhoneRQ rq : phones) {
			Phone phone = new Phone();
			phone.setCitycode(rq.getCityCode());
			phone.setContrycode(rq.getContrycode());
			phone.setNumber(rq.getNumber());
			phone.setUser(user);
			phoneList.add(phone);
		}

		return phoneList;
	}

	public static UserListRS userModelListToRS(List<User> userList) {
		UserListRS userListRS = new UserListRS();
		List<UserRS> usersRS = new ArrayList<>();
		for (User user : userList) {
			usersRS.add(userModelToRS(user));
		}
		userListRS.setUsers(usersRS);
		return userListRS;
	}

	public static UserRS userModelToRS(User user) {
		UserRS userRS = new UserRS();
		userRS.setEmail(user.getEmail());
		userRS.setName(user.getName());
		userRS.setPassword(user.getPassword());
		userRS.setPhones(phoneModelListToRs(user.getPhones()));
		return userRS;
	}

	public static List<PhoneRS> phoneModelListToRs(List<Phone> phones) {
		List<PhoneRS> phonesRS = new ArrayList<>();
		for (Phone phone : phones) {
			phonesRS.add(phoneModelToRs(phone));
		}
		return phonesRS;
	}

	public static PhoneRS phoneModelToRs(Phone phone) {
		PhoneRS phoneRS = new PhoneRS();
		
		phoneRS.setCityCode(phone.getCitycode());
		phoneRS.setContrycode(phone.getContrycode());
		phoneRS.setNumber(phone.getNumber());
		
		return phoneRS;
	}
}
