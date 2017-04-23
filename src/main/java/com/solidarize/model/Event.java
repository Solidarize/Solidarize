package com.solidarize.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "event_id_seq")
    @SequenceGenerator(name = "event_id_seq", sequenceName = "event_id_seq", allocationSize = 1)
    private Integer id;
    private String name;
    private String owner;
    private Integer rank;

    public Event() {
    }

    public Event(String name, String owner, Integer rank) {
        this.name = name;
        this.owner = owner;
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public String getOwner() {
        return owner;
    }

    public Integer getId() {
        return id;
    }

    public Integer getRank() {
        return rank;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }
}
