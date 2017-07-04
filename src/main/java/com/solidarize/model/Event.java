package com.solidarize.model;


import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "event_id_seq")
    @SequenceGenerator(name = "event_id_seq", sequenceName = "event_id_seq", allocationSize = 1)
    private Integer id;
    private String name;
    
    @ManyToOne
    @JoinColumn(name = "owner")
    private Institution owner;
    private int rank;
    private LocalDate timestamp;
    private String title;
    private String sub_title;
    private String address;
    private LocalDate event_time;
    private String description;
    
    @ManyToMany(mappedBy = "events")
    List<User> users;

    public Event() {
    }

    public Event(String name, Institution owner, Integer rank,
                 LocalDate timestamp, String title,
                 String sub_title, String address, LocalDate event_time, String description) {
        this.name = name;
        this.owner = owner;
        this.rank = rank;
        this.timestamp = timestamp;
        this.title = title;
        this.sub_title = sub_title;
        this.address = address;
        this.event_time = event_time;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public Institution getOwner() {
        return owner;
    }

    public Integer getId() {
        return id;
    }

    public Integer getRank() {
        return rank;
    }

    public String getTimestamp() {
        return timestamp.toString();
    }

    public String getTitle() {
        return title;
    }

    public String getSub_title() {
        return sub_title;
    }

    public String getAddress() {
        return address;
    }

    public String getEvent_time() {
        return event_time.toString();
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOwner(Institution owner) {
        this.owner = owner;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public void setTimestamp(LocalDate timestamp) {
        this.timestamp = timestamp;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSub_title(String sub_title) {
        this.sub_title = sub_title;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEvent_time(LocalDate event_time) {
        this.event_time = event_time;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @JsonIgnore
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}    
}
