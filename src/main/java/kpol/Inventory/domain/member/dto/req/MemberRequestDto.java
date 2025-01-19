package kpol.Inventory.domain.member.dto.req;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberRequestDto {
    private String username;
    private String nickname;
    private String email;
    private String password;
}
