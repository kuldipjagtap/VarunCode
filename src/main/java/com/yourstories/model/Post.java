package com.yourstories.model;

import java.time.Instant;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="post")
public class Post {

	@Id
	private String id;
	@NotBlank(message="title of the post must not be null")
	@Size(max=100)
	private String title;
	@NotBlank(message="article of the post must not be null")
	private String article;
	private String titleClean;
	@NotNull(message="date published must not be blank")
	private Instant datePublished;
	@NotBlank(message="imageurl must not be null")
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
	public String getTitleClean() {
		return titleClean;
	}
	public void setTitleClean(String titleClean) {
		this.titleClean = titleClean;
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
