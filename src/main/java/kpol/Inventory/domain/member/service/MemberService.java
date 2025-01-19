package kpol.Inventory.domain.member.service;

import kpol.Inventory.domain.member.entity.Member;
import kpol.Inventory.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    // 유저 정보 조회
    public Optional<Member> getMemberById(Long id) {
        return memberRepository.findById(id);
    }

    // 유저 정보 수정
    public Member updateMember(Long id, String nickname, String password) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));
        member.setNickname(nickname);
        member.setPassword(password);
        return memberRepository.save(member);
    }
}


