package com.yourstories.model;

import java.time.Instant;

public class Related {
	private String postId;
	private String relatedPostId;
	
	public String getPostId() {
		return postId;
	}
	public void setPostId(String postId) {
		this.postId = postId;
	}
	public String getRelatedPostId() {
		return relatedPostId;
	}
	public void setRelatedPostId(String relatedPostId) {
		this.relatedPostId = relatedPostId;
	}
	
}
