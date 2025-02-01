package pl.webapp.wsjava.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.webapp.wsjava.dto.CommentDTO;
import pl.webapp.wsjava.service.CommentService;
import pl.webapp.wsjava.service.Mapper;

@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/comment")
public class CommentController {

    private final CommentService commentService;
    private final Mapper modelMapper;

    public CommentController(CommentService commentService, Mapper modelMapper) {
        this.commentService = commentService;
        this.modelMapper = modelMapper;
    }

    //Get comment by id
    @GetMapping("/{id}")
    public ResponseEntity<CommentDTO> getCommentById(@PathVariable Long id) {
        return new ResponseEntity<>(modelMapper.toDTO(commentService.findById(id)), HttpStatus.OK);
    }


}
