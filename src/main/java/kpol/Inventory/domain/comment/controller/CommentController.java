package kpol.Inventory.domain.comment.controller;


import kpol.Inventory.domain.comment.dto.res.CommentResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public ResponseEntity<CommentResponseDto> createComment(@RequestBody CommentResponseDto responseDto) {
        return ResponseEntity.ok(commentService.getCommentsByboard(boardId));
    }

    @GetMapping("/board/{boardId}")
    public RespoEntity<List<CommentResponseDto>> getCommentsByboard(@PathVariable Long boardId) {
        return ResponseEntity.ok(commentService.getCommentsByBoard(boardId));
    }
}
