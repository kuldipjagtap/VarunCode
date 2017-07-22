package com.yourstories.services;

import java.util.List;

import com.yourstories.model.Author;
import com.yourstories.model.Comment;
import org.springframework.security.access.method.P;
import org.springframework.security.access.prepost.PreAuthorize;

public interface ICommentService {

	@PreAuthorize("hasAuthority('VIEW_ALL_COMMENTS')")
	List<Comment> getAllComment();
	@PreAuthorize("hasAuthority('VIEW_ALL_COMMENTS_BY_POST')")
	List<Comment> getCommentsByPost(String postId);
	@PreAuthorize("hasAuthority('VIEW_COMMENT')")
	Comment getComment(String id);
	@PreAuthorize("hasAuthority('CREATE_COMMENT')")
	Comment createComment(Comment comment);
	@PreAuthorize("#authentication.equals(c.user) and hasAuthority('UPDATE_OWN_COMMENT') or hasAuthority('UPDATE_OTHERS_COMMENT')")
	Comment updateComment(@P("c") Comment comment);
	@PreAuthorize("#authentication.equals(c.user) and hasAuthority('DELETE_OWN_COMMENT') or hasAuthority('DELETE_OTHERS_COMMENT')")
	void deleteComment(Comment comment);
	@PreAuthorize("hasAuthority('DELETE_OWN_COMMENT') or hasAuthority('DELETE_OTHERS_COMMENT')")
	void deleteComment(String commentId);
}
