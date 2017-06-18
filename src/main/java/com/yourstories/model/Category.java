package com.yourstories.model;

import java.time.Instant;

public class Category {

	private String id;
	private String name;
	private String nameClean;
	private Boolean enabled;
	private Instant dateCreated;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getNameClean() {
		return nameClean;
	}
	public void setNameClean(String nameClean) {
		this.nameClean = nameClean;
	}
	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	public Instant getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Instant dateCreated) {
		this.dateCreated = dateCreated;
	}
	
	
	
}
