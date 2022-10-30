package se331.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se331.rest.dao.CommentDao;
import se331.rest.entity.Comment;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService{
    @Autowired
    CommentDao commentDao;
    @Override
    public Integer getCommentSize() {
        return commentDao.getCommentSize();
    }

    @Override
    public Comment getComment(Long id) {
        return commentDao.getComment(id);
    }

    @Override
    public List<Comment> getComments() {
        return commentDao.getComments();
    }

    @Override
    public Comment save(Comment comment,Long did,Long pid) {
        return commentDao.save(comment,did,pid);
    }

    @Override
    public List<Comment> FindByPid(Long pid) {
        return commentDao.FindByPid(pid);
    }
}
