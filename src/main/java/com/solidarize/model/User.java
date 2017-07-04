package com.solidarize.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity(name = "solidarize_user")
public class User {
    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_seq")
//    @SequenceGenerator(name = "user_id_seq", sequenceName = "user_id_seq", allocationSize = 1)
    private Integer id;
    private String login;
    private String password;
    /* 1 - Instituição
       2 - Voluntário*/
    private int type;
    private String mail;
    
    @ManyToMany
    @JoinTable(name = "event_user", joinColumns = @JoinColumn(name = "solidarize_user", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "event", referencedColumnName = "id"))
    List<Event> events;

    public User(Integer id, String login, String password, int type, String mail) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.type = type;
        this.mail = mail;
    }

    public User(String login, String password, int type, String mail) {
        this.login = login;
        this.password = password;
        this.type = type;
        this.mail = mail;
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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}
    
}
