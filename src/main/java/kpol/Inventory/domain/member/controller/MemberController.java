package kpol.Inventory.domain.member.controller;

import kpol.Inventory.domain.board.dto.res.BoardResponseDto;
import kpol.Inventory.domain.board.entity.Board;
import kpol.Inventory.domain.member.dto.req.MemberRequestDto;
import kpol.Inventory.domain.member.dto.res.MemberResponseDto;
import kpol.Inventory.domain.member.entity.Member;
import kpol.Inventory.domain.member.repository.UserDetailsImpl;
import kpol.Inventory.domain.member.service.MemberService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/members/me")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    // 유저 정보 조회
    @GetMapping
    public ResponseEntity<MemberResponseDto> getMember(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        Member member = userDetails.getMember();
        MemberResponseDto memberResponse = memberService.getMemberById(member.getId());
        return ResponseEntity.ok(memberResponse);
     }

    // 유저 정보 수정
    @PutMapping
    public ResponseEntity<MemberResponseDto> updateMember(
            @AuthenticationPrincipal UserDetailsImpl userDetails,
            @RequestBody MemberRequestDto updateDto) {
        Member member = userDetails.getMember();
        MemberResponseDto updatedMember = memberService.updateMember(
                member.getId(), updateDto.getNickname(), updateDto.getPassword());

        return ResponseEntity.ok(updatedMember);
    }

    // 작성 게시물 조회
    @GetMapping("/boards")
    public ResponseEntity<List<BoardResponseDto>> getMyBoards(
            @AuthenticationPrincipal UserDetailsImpl userDetails){
        Member member = userDetails.getMember();
        List<BoardResponseDto> myBoards = memberService.getMyBoards(member.getId());
        return ResponseEntity.ok(myBoards);
     }

    // 좋아요 게시물 조회
    @GetMapping("/liked-boards")
    public ResponseEntity<List<BoardResponseDto>> getLikedBoards(
            @AuthenticationPrincipal UserDetailsImpl userDetails){
        Member member = userDetails.getMember();
        List<BoardResponseDto> likedBoards = memberService.getLikedBoards(member.getId());
        return ResponseEntity.ok(likedBoards);

    }
}