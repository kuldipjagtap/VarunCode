package com.yourstories.model;

import java.time.Instant;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="comment")
public class Comment {

	@Id
	private String id;
	@NotBlank(message="comment must not be null")
	private String comment;
	private Boolean markRead;
	private Boolean enabled;
	@NotBlank(message="date must not be null")
	private Instant date;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Boolean getMarkRead() {
		return markRead;
	}
	public void setMarkRead(Boolean markRead) {
		this.markRead = markRead;
	}
	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	public Instant getDate() {
		return date;
	}
	public void setDate(Instant date) {
		this.date = date;
	}
}
