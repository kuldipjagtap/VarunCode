package com.yourstories.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.yourstories.model.Comment;
import com.yourstories.repositories.ICommentRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentService implements ICommentService{

	@Autowired ICommentRepository commentRepository;
	
	@Override
	public List<Comment> getAllComment() {
		
		return commentRepository.getAllComment();
	}

	@Override
	public Comment getComment(String id) {
		
		return commentRepository.getComment(id);
	}

	@Override
	public Comment createComment(Comment comment) {
		
		return commentRepository.createComment(comment);
	}

	@Override
	public Comment updateComment(Comment comment) {
		
		return commentRepository.updateComment(comment);
	}

	@Override
	public void deleteComment(Comment comment) {
		
		commentRepository.deleteComment(comment);
	}

	@Override
	public void deleteComment(String id) {
		
		commentRepository.deleteComment(id);
	}

	@Override
	public List<Comment> getCommentsByPost(String postId) {
		return commentRepository.getCommentsByPost(postId);
	}
}
