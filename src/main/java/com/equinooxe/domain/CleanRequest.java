/*
 * Copyright (C) 2015 Mohamed Boullouz.
 * contact: <mohamed.boullouz@gmail.com>
 * This file is part of equinooxe Project
 */
package com.equinooxe.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 *
 * @author mohamed
 */
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
public class CleanRequest extends AbstractAuditingEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	private LocalDateTime startAt;
	private LocalDateTime deadlineDate;
	private LocalDateTime doneAt;

	@Column(unique = false, columnDefinition = "TEXT")
	private String instructions;

	@Column
	private String status = DomainConsts.Status.EN_ATTENTE;

	@ManyToOne
	private AgentUser agent;

	@ManyToOne
	private ManagerUser manager;

	@OneToMany(mappedBy = "cleanRequest", targetEntity = CleanTask.class)
	@Fetch(FetchMode.JOIN)
	@Cascade({ CascadeType.ALL })
	private Collection<CleanTask> cleanTasks;

	@ManyToOne
	private Espace espace;

	public CleanRequest() {
		super();
	}

	public void addCleanTask(CleanTask cleanTask) {
		this.cleanTasks.add(cleanTask);
	}

	public String getStatus() {
		return status;
	}

	public String getStatusStr() {
		return DomainConsts.Status.toString(this.status);
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Espace getEspace() {
		return espace;
	}

	public void setEspace(Espace espace) {
		this.espace = espace;
	}

	public LocalDateTime getStartAt() {
		return startAt;
	}

	public void setStartAt(LocalDateTime startAt) {
		this.startAt = startAt;
	}

	public LocalDateTime getDeadlineDate() {
		return deadlineDate;
	}

	public void setDeadlineDate(LocalDateTime deadlineDate) {
		this.deadlineDate = deadlineDate;
	}

	public LocalDateTime getDoneAt() {
		return doneAt;
	}

	public void setDoneAt(LocalDateTime doneAt) {
		this.doneAt = doneAt;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	public AgentUser getAgent() {
		return agent;
	}

	public void setAgent(AgentUser agent) {
		this.agent = agent;
	}

	public ManagerUser getManager() {
		return manager;
	}

	public void setManager(ManagerUser manager) {
		this.manager = manager;
	}

	public Collection<CleanTask> getCleanTasks() {
		return cleanTasks;
	}

	public void setCleanTasks(Collection<CleanTask> cleanTasks) {
		this.cleanTasks = cleanTasks;
	}

	public void addAll(Set<CleanTask> cleanTasks) {
		this.cleanTasks.clear(); 
		cleanTasks.forEach(c -> {
			this.cleanTasks.add(c);
		});
	}

	public Espace getLocation() {
		return espace;
	}

	public void setLocation(Espace espace) {
		this.espace = espace;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof CleanRequest)) {
			return false;
		}
		CleanRequest other = (CleanRequest) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	public void remove(CleanTask cl) {
		this.cleanTasks.remove(cl);
	}

}
