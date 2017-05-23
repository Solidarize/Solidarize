package com.solidarize.model;

import java.time.LocalDate;

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
	private LocalDate timestamp;
	private String title;
	private String sub_title;
	private String address;
	private LocalDate event_time;
	private String description;
	private Integer Liked;

	public Event() {
	}

	public Event(String name, String owner, Integer rank, LocalDate timestamp, String title, String sub_title,
			String address, LocalDate event_time, String description) {
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

	public String getOwner() {
		return owner;
	}

	public Integer getId() {
		return id;
	}

	public Integer getRank() {
		return rank;
	}

	public LocalDate getTimestamp() {
		return timestamp;
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

	public void setOwner(String owner) {
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

	public Integer getLiked() {
		return Liked;
	}

	public void setLiked(Integer liked) {
		Liked = liked;
	}

}