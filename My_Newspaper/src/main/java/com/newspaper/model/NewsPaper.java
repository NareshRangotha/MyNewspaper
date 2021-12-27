package com.newspaper.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class NewsPaper {


	@Override
	public String toString() {
		return "NewsPaper [newspaperid=" + newspaperid + ", title=" + title + ", description=" + description + ", rate="
				+ rate + ", language=" + language + ", vendor=" + vendor + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long newspaperid;

	private String title;
	private String description;
	private double rate;
	private String language;
	@ManyToOne
	@JoinColumn(name="vendor")
	private User vendor;

	public long getNewspaperid() {
		return newspaperid;
	}

	public void setNewspaperid(long newspaperid) {
		this.newspaperid = newspaperid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
	
	public User getVendor() {
		return vendor;
	}
	public void setVendor(User vendor) {
		this.vendor = vendor;
	}

	public NewsPaper() {
		super();
		// TODO Auto-generated constructor stub
	}

}
