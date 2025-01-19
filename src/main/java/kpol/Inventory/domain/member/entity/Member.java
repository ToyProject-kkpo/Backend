package kpol.Inventory.domain.member.entity;

import jakarta.persistence.*;
import kpol.Inventory.domain.board.entity.Board;
import kpol.Inventory.domain.comment.entity.Comment;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    @Setter(AccessLevel.PUBLIC)
    private String nickname;

    @Column(nullable = false, unique = true)
    private String email;

    @Setter(AccessLevel.PUBLIC)
    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String role;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Board> boards = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();
}
