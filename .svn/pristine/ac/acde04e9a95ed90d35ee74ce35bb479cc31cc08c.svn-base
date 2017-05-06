package com.supinfo.supcrowdfunder.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@SuppressWarnings("serial")
@Table(name="DONATIONS")
@XmlRootElement
public class Donate implements Serializable{

	@Id 
	@GeneratedValue
	private long donateId;
	private float amount;
	
	@ManyToOne
	@JoinColumn
	private User user;
	
	@ManyToOne
	@JoinColumn
	private Project project;
	
	public long getDonateId() {
		return donateId;
	}
	public void setDonateId(long donateId) {
		this.donateId = donateId;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
}