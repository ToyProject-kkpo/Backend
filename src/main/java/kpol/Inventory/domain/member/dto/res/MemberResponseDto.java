package kpol.Inventory.domain.member.dto.res;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberResponseDto {
    private Long id;
    private String username;
    private String nickname;
    private String email;
}
