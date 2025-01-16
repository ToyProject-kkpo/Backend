package kpol.Inventory.domain.comment.dto.req;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommentRequestDto {
    private String content;
    private Long boardId;
    private Long memberId; // 댓글 작성자
    private Long parentCommentId; // 부모 댓글 (없으면 null)
}
