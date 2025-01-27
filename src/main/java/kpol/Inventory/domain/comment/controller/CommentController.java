package kpol.Inventory.domain.comment.controller;


import kpol.Inventory.domain.comment.dto.req.CommentRequestDto;
import kpol.Inventory.domain.comment.dto.res.CommentResponseDto;
import kpol.Inventory.domain.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/comment")
public class CommentController {

    private final CommentService commentService;

    // 댓글 생성 API
    @PostMapping("/{boardId}/{memberId}")
    public ResponseEntity<CommentResponseDto> createComment(

            //url 경로에서 id 를 추출
            @PathVariable Long boardId,
            @PathVariable Long memberId,

            // json 데이터를 dto 객체로 변환 , 댓글 생성 , 생성된 댓글 정보를 dto로 반환
            @RequestBody CommentRequestDto requestDto) {
        CommentResponseDto responseDto = commentService.createComment(boardId, memberId, requestDto);
        return ResponseEntity.ok(responseDto);
    }

    //boardId에 속한 댓글 조회
    @GetMapping("/{boardId}")
    public ResponseEntity<List<CommentResponseDto>> getCommentsByBoardId(@PathVariable Long boardId) {
        List<CommentResponseDto> comments = commentService.getCommentByBoard(boardId);
        return ResponseEntity.ok(comments);
    }

    //수정 API
    @PutMapping("/{commentId}")
    public ResponseEntity<CommentResponseDto> updateComment(
            @PathVariable Long commentId,
            @RequestBody CommentRequestDto requestDto){
        CommentResponseDto responseDto = commentService.updateComment(commentId,requestDto);
        return ResponseEntity.ok(responseDto);
    }

    // 삭제 API
    @DeleteMapping("/{commentId")
    public ResponseEntity<Void> deleteComment(@PathVariable Long commentId) {
        commentService.deleteComment(commentId);
        return ResponseEntity.noContent().build();
    } // Id 받아오면 안 되나요..?
}
