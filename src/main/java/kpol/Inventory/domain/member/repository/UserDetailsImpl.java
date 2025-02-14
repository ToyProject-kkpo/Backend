package kpol.Inventory.domain.member.repository;

import kpol.Inventory.domain.member.entity.Member;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Getter
public class UserDetailsImpl implements UserDetails {
    private final Member member; // 로그인한 회원 정보

    public UserDetailsImpl(Member member){
        this.member = member;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        return member.getAuthorities();
    }

    @Override
    public String getPassword() {
        return member.getPassword();
    }

    @Override
    public String getUsername() {
        return member.getNickname();
    }

    @Override
    public boolean isEnabled() {
        return true; // 계정 활성화 여부
    }
}
