package kpol.Inventory.domain.member.dto.res;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SignupResponseDto {

    private String email;
    private String nickname;
}
