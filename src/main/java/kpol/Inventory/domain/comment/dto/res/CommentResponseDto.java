package kpol.Inventory.domain.comment.dto.res;


import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder

public class CommentResponseDto {
    private Long id;
    private String content;
    private String authorName; // 작성자 이름
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Long parentCommentId; // 부모 댓글 ID
}
