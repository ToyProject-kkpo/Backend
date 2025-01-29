package kpol.Inventory.domain.member.controller;

import kpol.Inventory.domain.member.dto.req.MemberRequestDto;
import kpol.Inventory.domain.member.dto.res.MemberResponseDto;
import kpol.Inventory.domain.member.entity.Member;
import kpol.Inventory.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    // 유저 정보 조회
    @GetMapping("/{id}")
    public ResponseEntity<MemberResponseDto> getMember(@PathVariable Long id) {
        MemberResponseDto member = memberService.getMemberById(id);
        return ResponseEntity.ok(member);
    }

    // 유저 정보 수정
    @PutMapping("/{id}")
    public ResponseEntity<MemberResponseDto> updateMember(
            @PathVariable Long id,
            @RequestBody MemberRequestDto updateDto) {

        MemberResponseDto updatedMember = memberService.updateMember(
                id, updateDto.getNickname(), updateDto.getPassword());

        return ResponseEntity.ok(updatedMember);
    }
}