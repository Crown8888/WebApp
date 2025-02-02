package pl.webapp.wsjava.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.webapp.wsjava.dto.LikeDTO;
import pl.webapp.wsjava.service.LikeService;
import pl.webapp.wsjava.service.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/likes")
public class LikeController {

    private final LikeService likeService;
    private final Mapper modelMapper;

    public LikeController(LikeService likeService, Mapper modelMapper) {
        this.likeService = likeService;
        this.modelMapper = modelMapper;
    }

    //Get likes by post id
    @GetMapping("/post/{postId}")
    public ResponseEntity<Integer> getLikesByPostId(@PathVariable Long postId) {
        return ResponseEntity.ok(Integer.valueOf(likeService.getLikeCount(postId)));
    }

    //Add like
    @GetMapping("/add/{postId}")
    public ResponseEntity<LikeDTO> addLike(@PathVariable Long postId) {
        return ResponseEntity.ok(modelMapper.toDTO(likeService.toggleLike(postId)));
    }
}
