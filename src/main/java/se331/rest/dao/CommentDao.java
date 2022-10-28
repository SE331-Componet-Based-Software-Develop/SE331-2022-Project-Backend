package se331.rest.dao;

import se331.rest.entity.Comment;

import java.util.List;

public interface CommentDao {
    Integer getCommentSize();
    Comment getComment(Long id);
    List<Comment> getComments();
    Comment save(Comment comment,Long did,Long pid);

}
