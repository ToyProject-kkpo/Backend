package kpol.Inventory.domain.comment.repository;

import kpol.Inventory.domain.comment.entity.Comment;

import java.util.List;

public class CommentRepository {
    // 게시글의 모든 댓글 조회
    List<Comment> findAllByBoardId(Long boardId);
    // 댓글의 모든 대댓글 조회
    List<Comment> findAllByParentCommentId(Long ParentCommentId);
}
