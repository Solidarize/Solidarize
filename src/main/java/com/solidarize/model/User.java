package com.solidarize.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_seq")
    @SequenceGenerator(name = "user_id_seq", sequenceName = "user_id_seq", allocationSize = 1)
    private Integer id;
	private String login;
	private String password;
/* 1 - Instituição
   2 - Voluntário*/
	private int type;

	public User(Integer id, String login, String password, int type) {
		this.id = id;
		this.login = login;
		this.password = password;
		this.type = type;
	} 
	public User(String login, String password, int type) {
		this.login = login;
		this.password = password;
		this.type = type;
	}	
	public User() {
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getType() {
		return type;
	}
	public void setType(byte type) {
		this.type = type;
	}
	
}
