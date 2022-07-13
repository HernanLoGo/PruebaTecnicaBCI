//package com.bci.prueba.tecnica.pruebatecnica.model;
//
//import java.io.Serializable;
//import java.util.List;
//import java.util.UUID;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;
//
//import org.hibernate.annotations.ColumnDefault;
//import org.hibernate.annotations.GenericGenerator;
//import org.hibernate.annotations.Type;
//import org.springframework.data.annotation.Persistent;
//
//@Entity
//@Persistent
//@Table(name = "User")
//public class User implements Serializable {
//
//	private static final long serialVersionUID = 2441410364316776279L;
//
//	@Id
//	@GeneratedValue(generator = "UUID")
//	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
//	@ColumnDefault("random_uuid()")
//	@Type(type = "uuid-char")
//	private UUID id;
//
//	@Column(name = "name", nullable = false)
//	private String name;
//
//	@Column(name = "email", nullable = false)
//	private String email;
//
//	@Column(name = "password", nullable = false)
//	private String password;
//
//	@OneToMany(mappedBy = "user")
//	private List<Phone> phones;
//
//	public UUID getId() {
//		return id;
//	}
//
//	public void setId(UUID id) {
//		this.id = id;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//	public List<Phone> getPhones() {
//		return phones;
//	}
//
//	public void setPhones(List<Phone> phones) {
//		this.phones = phones;
//	}
//
//	@Override
//	public String toString() {
//		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", phones="
//				+ phones + "]";
//	}
//
//}
