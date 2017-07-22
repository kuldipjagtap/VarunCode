package com.yourstories.services;

import java.util.List;

import com.yourstories.model.Author;
import com.yourstories.model.Tag;
import org.springframework.security.access.prepost.PreAuthorize;

public interface ITagService {

	@PreAuthorize("hasAuthority('USER')")
	List<Tag> getAllTags();
	@PreAuthorize("hasAuthority('USER')")
	Tag getTag(String id);
	@PreAuthorize("hasAuthority('USER')")
	Tag createTag(Tag tag);
	@PreAuthorize("hasAuthority('USER')")
	Tag updateTag(Tag tag);
	@PreAuthorize("hasAuthority('USER')")
	void deleteTag(Tag tag);
	@PreAuthorize("hasAuthority('USER')")
	void deleteTag(String id);
}
