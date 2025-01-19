package kpol.Inventory.domain.member.repository;


import kpol.Inventory.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MemberRepository extends JpaRepository<Member, Long> {

    Member findByNickname(String nickname);
    Member findByEmail(String email);

}
