package com.yourstories.model;

import java.time.Instant;

public class Comment {

	private String id;
	private String comment;
	private Boolean markRead;
	private Boolean enabled;
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
