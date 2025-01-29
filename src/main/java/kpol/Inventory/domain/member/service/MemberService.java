package kpol.Inventory.domain.member.service;

import kpol.Inventory.domain.member.dto.res.MemberResponseDto;
import kpol.Inventory.domain.member.entity.Member;
import kpol.Inventory.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    // 인증된 유저 정보 조회
    public MemberResponseDto getMemberById(@AuthenticationPrincipal Member member) {
        if(member==null){
            throw new RuntimeException("인증된 사용자가 없습니다.");
        }
        return new MemberResponseDto(member.getId(), member.getNickname(), member.getNickname(), member.getEmail());
    }

    // 유저 정보 수정
    public MemberResponseDto updateMember(@AuthenticationPrincipal Member member, String nickname, String password) {

        if(member == null){
            throw new IllegalArgumentException("인증된 사용자가 없습니다.");
        }
        // 닉네임, 비밀번호 변경
        member.updateInfo(nickname, password);
        return new MemberResponseDto(member.getId(), member.getNickname(), member.getNickname(), member.getEmail());
    }
}


