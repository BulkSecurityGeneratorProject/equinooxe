/*
 * Copyright (C) 2015 Mohamed Boullouz.
 * contact: <mohamed.boullouz@gmail.com>
 * This file is part of equinooxe Project
 */
package com.equinooxe.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 *
 * @author mohamed
 */
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
public class TacheDefinition extends AbstractAuditingEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	@Column(unique = true)
	private String nom;

	@Column(unique = false, columnDefinition = "TEXT")
	private String description;

	public TacheDefinition() {
		super();
	}

	public TacheDefinition(String nom, String description) {
		super();
		this.nom = nom;
		this.description = description;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String name) {
		this.nom = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof TacheDefinition)) {
			return false;
		}
		TacheDefinition other = (TacheDefinition) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}
}
