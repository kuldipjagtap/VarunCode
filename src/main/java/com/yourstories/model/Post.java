package com.yourstories.model;

import java.time.Instant;

public class Post {

	private String id;
	private String title;
	private String article;
	private String title_clean;
	private Instant datePublished;
	private String bannerImage;
	private Boolean featured;
	private Boolean enabled;
	private Boolean commentsEnabled;
	private Integer views;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getArticle() {
		return article;
	}
	public void setArticle(String article) {
		this.article = article;
	}
	public String getTitle_clean() {
		return title_clean;
	}
	public void setTitle_clean(String title_clean) {
		this.title_clean = title_clean;
	}
	public Instant getDatePublished() {
		return datePublished;
	}
	public void setDatePublished(Instant datePublished) {
		this.datePublished = datePublished;
	}
	public String getBannerImage() {
		return bannerImage;
	}
	public void setBannerImage(String bannerImage) {
		this.bannerImage = bannerImage;
	}
	public Boolean getFeatured() {
		return featured;
	}
	public void setFeatured(Boolean featured) {
		this.featured = featured;
	}
	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	public Boolean getCommentsEnabled() {
		return commentsEnabled;
	}
	public void setCommentsEnabled(Boolean commentsEnabled) {
		this.commentsEnabled = commentsEnabled;
	}
	public Integer getViews() {
		return views;
	}
	public void setViews(Integer views) {
		this.views = views;
	}
	
	
}
