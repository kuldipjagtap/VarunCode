package com.yourstories.model;

import org.bson.types.ObjectId;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Document(collection="post")
public class Post implements Serializable{

	@Id
	private ObjectId id;
	@NotBlank(message="title of the post must not be null")
	@Size(max=100)
	private String title;
	@NotBlank(message="article of the post must not be null")
	private String article;
	private String titleClean;
	@NotNull(message="date published must not be blank")
	private Date datePublished;
	@NotBlank(message="imageurl must not be null")
	private String bannerImage;
	private Boolean featured;
	private Boolean enabled;
	private Boolean commentsEnabled;
	private Integer views;
	private List<Author> authors;
	private List<Category> categories;
	private List<Related> relatedPosts;
	private List<Tag> tags;

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
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

	public Date getDatePublished() {
		return datePublished;
	}

	public void setDatePublished(Date datePublished) {
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

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public List<Related> getRelatedPosts() {
		return relatedPosts;
	}

	public void setRelatedPosts(List<Related> relatedPosts) {
		this.relatedPosts = relatedPosts;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
}
