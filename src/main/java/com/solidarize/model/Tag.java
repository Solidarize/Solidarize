package com.solidarize.model;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
@Entity
public class Tag {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tag_id_seq")
	@SequenceGenerator(name = "tag_id_seq", sequenceName = "tag_id_seq", allocationSize  = 1)
	private BigInteger id;	
	private Integer identifier;
	private String tagname;
	
	public Tag() {
		super();
	}

	public Tag(Integer identifier, String tagname) {
		this.identifier = identifier;
		this.tagname = tagname;
	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public Integer getIdentifier() {
		return identifier;
	}

	public void setIdentifier(Integer identifier) {
		this.identifier = identifier;
	}

	public String getTagname() {
		return tagname;
	}

	public void setTagname(String tagname) {
		this.tagname = tagname;
	}
	
}
