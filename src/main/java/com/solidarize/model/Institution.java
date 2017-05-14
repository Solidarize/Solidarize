package com.solidarize.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;

import org.springframework.data.annotation.Id;

@Entity
public class Institution {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "institution_id_seq")
	@SequenceGenerator(name = "institution_id_seq", sequenceName = "institution_id_seq", allocationSize  = 1)
	private Integer id;	
	private String name;
	private String cnpj;
	private String address;
	private String description;
	private String password;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
