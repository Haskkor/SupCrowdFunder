package com.supinfo.supcrowdfunder.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@SuppressWarnings("serial")
@Table(name="PROJECTS")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Project implements Serializable{
	
	@Id 
	@GeneratedValue
	private long projectId;
	
	private String creator;
	private String name;
	private String creationDate;
	private String completionDate;
	private float amountNeeded;
	private float donationAmount;
	private String description;
	
	@ManyToOne
	@JoinColumn
	private Category category;
	
	@XmlTransient
	@OneToMany(mappedBy="project")
	private List<Donate> listDonate;

	public long getProjectId() {
		return projectId;
	}

	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public String getCompletionDate() {
		return completionDate;
	}

	public void setCompletionDate(String completionDate) {
		this.completionDate = completionDate;
	}

	public float getDonationAmount() {
		return donationAmount;
	}

	public void setDonationAmount(float donationAmount) {
		this.donationAmount = donationAmount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getAmountNeeded() {
		return amountNeeded;
	}

	public void setAmountNeeded(float amountNeeded) {
		this.amountNeeded = amountNeeded;
	}

	public List<Donate> getListDonate() {
		return listDonate;
	}

	public void setListDonate(List<Donate> listDonate) {
		this.listDonate = listDonate;
	}
}