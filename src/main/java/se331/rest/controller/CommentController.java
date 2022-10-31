package se331.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;
import se331.rest.entity.Comment;
import se331.rest.service.CommentService;
import se331.rest.util.LabMapper;

import java.util.List;

@Controller
public class CommentController {
    @Autowired
    CommentService commentService;
    @GetMapping("/comments")
    public ResponseEntity<?> getCommentLists(){
        List<Comment> output;
        output = commentService.getComments();
        if (output != null)
            return ResponseEntity.ok(LabMapper.INSTANCE.getCommentDTO(output));
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"The given id is not found");

    }

    @GetMapping("/commentsbypid")
    public ResponseEntity<?> getCommentListsByPid(@RequestParam(value = "pid",required = false)Long pid){
        List<Comment> output;
        output = commentService.FindByPid(pid);
        if (output != null)
            return ResponseEntity.ok(LabMapper.INSTANCE.getCommentDTO(output));
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"The given id is not found");

    }

    @PostMapping("/comment")
    public ResponseEntity<?> addComment(@RequestBody Comment comment,
                                        @RequestParam(value = "did",required = false)Long did,
                                        @RequestParam(value = "pid",required = false)Long pid){
        Comment output = commentService.save(comment,did,pid);
        return ResponseEntity.ok(LabMapper.INSTANCE.getCommentDTO(output));
    }
}
