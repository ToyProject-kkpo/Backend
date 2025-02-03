package kpol.Inventory.domain.comment.controller;


import kpol.Inventory.domain.comment.dto.req.CommentRequestDto;
import kpol.Inventory.domain.comment.dto.res.CommentResponseDto;
import kpol.Inventory.domain.comment.service.CommentService;
import kpol.Inventory.domain.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/comment")
public class CommentController {

    private final CommentService commentService;

    // 댓글 생성 API
    @PostMapping("/{boardId}")
    public ResponseEntity<CommentResponseDto> createComment(
            @PathVariable Long boardId, // URL 경로에서 boardId 추출
            @AuthenticationPrincipal Member member, // 현재 로그인한 사용자 정보
            @Valid @RequestBody CommentRequestDto requestDto) { // 요청 본문 데이터
        CommentResponseDto responseDto = commentService.createComment(boardId, member, requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
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
            @AuthenticationPrincipal Member member, // 현재 로그인한 사용자 정보
            @Valid @RequestBody CommentRequestDto requestDto){
        CommentResponseDto responseDto = commentService.updateComment(commentId,requestDto);
        return ResponseEntity.ok(responseDto);
    }

    // 삭제 API
    @DeleteMapping("/{commentId")
    public ResponseEntity<Void> deleteComment(
            @PathVariable Long commentId,
            @AuthenticationPrincipal Member member) {
        commentService.deleteComment(commentId, member);
        return ResponseEntity.noContent().build();
    }
}
