package com.gachon.gothood.domain.controller;

import com.gachon.gothood.domain.member.dto.MemberLoginRequestDto;
import com.gachon.gothood.domain.member.dto.MemberLoginResponseDto;
import com.gachon.gothood.domain.member.dto.MemberRegisterRequestDto;
import com.gachon.gothood.domain.member.dto.MemberRegisterResponseDto;
import com.gachon.gothood.domain.member.service.MemberService;
import com.gachon.gothood.global.response.BaseResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/member")
    public BaseResponseDto<MemberRegisterResponseDto> register(
            @RequestBody MemberRegisterRequestDto requestDto
    ) {
        return memberService.register(
                requestDto.getMemberId(),
                requestDto.getPassword(),
                requestDto.getGender(),
                requestDto.getAge()
        );
    }

    @GetMapping("/member")
    public BaseResponseDto<MemberLoginResponseDto> login(
            @RequestBody MemberLoginRequestDto requestDto
    ) {
        return memberService.login(
                requestDto.getMemberId(),
                requestDto.getPassword()
        );
    }
}
