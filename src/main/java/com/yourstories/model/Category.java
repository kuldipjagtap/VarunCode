package com.yourstories.model;

import java.time.Instant;
import java.util.Date;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="category")
public class Category {

	@Id
	private String id;
	@NotBlank(message="name must not be blank")
	@Size(min=5,max=25,message="name must have characters between 5 to 25")
	private String name;
	private String nameClean;
	private Boolean enabled;
	@NotBlank(message="dateCreated must not be blank")
	private Date dateCreated;
	
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

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
}
