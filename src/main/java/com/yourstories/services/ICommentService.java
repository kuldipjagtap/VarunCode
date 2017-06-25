package com.yourstories.services;

import java.util.List;

import com.yourstories.model.Author;
import com.yourstories.model.Comment;

public interface ICommentService {

	List<Comment> getAllComment();
	Comment getComment(String id);
	Comment createComment(Comment comment);
	Comment updateComment(Comment comment);
	void deleteComment(Comment comment);
	void deleteComment(String id);
}
