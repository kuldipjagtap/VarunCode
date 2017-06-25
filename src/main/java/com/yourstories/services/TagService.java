package com.yourstories.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.yourstories.model.Tag;
import com.yourstories.repositories.ITagRepository;
import org.springframework.stereotype.Service;

@Service
public class TagService implements ITagService{

	@Autowired ITagRepository tagRepository;
	
	@Override
	public List<Tag> getAllTags() {
		
		return tagRepository.getAllTags();
	}

	@Override
	public Tag getTag(String id) {
		
		return tagRepository.getTag(id);
	}

	@Override
	public Tag createTag(Tag tag) {
		
		return tagRepository.createTag(tag);
	}

	@Override
	public Tag updateTag(Tag tag) {
		
		return tagRepository.updateTag(tag);
	}

	@Override
	public void deleteTag(Tag tag) {
		
		tagRepository.deleteTag(tag);
	}

	@Override
	public void deleteTag(String id) {
		
		tagRepository.deleteTag(id);
	}

	
}
