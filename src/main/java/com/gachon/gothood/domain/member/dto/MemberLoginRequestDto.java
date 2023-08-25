package com.gachon.gothood.domain.member.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor(staticName = "of")
@Getter
@Setter
@Builder
public class MemberLoginRequestDto {

    private String memberId;
    private String password;
}
