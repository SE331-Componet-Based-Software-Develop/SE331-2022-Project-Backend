package se331.rest.service;

import se331.rest.entity.Comment;

import java.util.List;

public interface CommentService {
    Integer getCommentSize();
    Comment getComment(Long id);
    List<Comment> getComments();
    Comment save(Comment comment,Long did,Long pid);
    List<Comment> FindByPid(Long pid);
}
