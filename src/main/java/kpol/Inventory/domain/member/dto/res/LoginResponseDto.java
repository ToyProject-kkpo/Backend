package kpol.Inventory.domain.member.dto.res;

import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
@Builder
public class LoginResponseDto {

    private String accessToken;
    private String refreshToken;
    private Long accessTokenExpires;
    private Date accessTokenExpiresDate;
}
