package com.yourstories.services;

import java.util.List;

import com.yourstories.model.Author;
import com.yourstories.model.Tag;

public interface ITagService {

	List<Tag> getAllTags();
	Tag getTag(String id);
	Tag createTag(Tag tag);
	Tag updateTag(Tag tag);
	void deleteTag(Tag tag);
	void deleteTag(String id);
}
