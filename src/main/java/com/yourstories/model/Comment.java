package com.yourstories.model;

import java.time.Instant;
import java.util.Date;

import org.bson.types.ObjectId;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="comment")
public class Comment {

	@Id
	private ObjectId id;
	@NotBlank(message="postId of the comment must not be null")
	private String postId;
	@NotBlank(message="comment must not be null")
	private String comment;
	private Boolean markRead;
	private Boolean enabled;
	@NotBlank(message="date must not be null")
	private Date createdDate;
	private User user;

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getPostId() {
		return postId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
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

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
