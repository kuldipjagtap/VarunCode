package com.yourstories.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.yourstories.model.Comment;
import org.springframework.stereotype.Repository;

@Repository
public class CommentRepository implements ICommentRepository{

	@Autowired MongoTemplate mongoTemplate;
	@Autowired CommentRepositoryDB commentRepositoryDB;
	
	@Override
	public List<Comment> getAllComment() {
		
		return commentRepositoryDB.findAll();
	}

	@Override
	public Comment getComment(String id) {
		
		return commentRepositoryDB.findOne(id);
	}

	@Override
	public Comment createComment(Comment comment) {
		
		return commentRepositoryDB.save(comment);
	}

	@Override
	public Comment updateComment(Comment comment) {
		
		return commentRepositoryDB.save(comment);
	}

	@Override
	public void deleteComment(Comment comment) {
		commentRepositoryDB.delete(comment);
		
	}

	@Override
	public void deleteComment(String id) {
		commentRepositoryDB.delete(id);
		
	}

	
}
