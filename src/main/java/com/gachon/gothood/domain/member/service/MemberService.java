package com.gachon.gothood.domain.member.service;

import com.gachon.gothood.domain.member.dto.MemberLoginResponseDto;
import com.gachon.gothood.domain.member.dto.MemberRegisterResponseDto;
import com.gachon.gothood.domain.member.entity.Member;
import com.gachon.gothood.domain.member.repository.MemberRepository;
import com.gachon.gothood.global.response.BaseResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public BaseResponseDto<MemberRegisterResponseDto> register(
            String id, String password, Boolean gender, int age
            ) {

        Member member = Member.builder()
            .memberId(id)
            .password(password)
            .gender(gender)
            .age(age)
            .build();

        memberRepository.save(member);

        return new BaseResponseDto<>(MemberRegisterResponseDto.of(true));
    }

    public BaseResponseDto<MemberLoginResponseDto> login(String id, String password) {

        Member m = memberRepository.findByMemberId(id).orElse(null);

        if (m == null) {
            return new BaseResponseDto<>(MemberLoginResponseDto.of(false));
        } else {
            if (m.getPassword().equals(password)) {
                return new BaseResponseDto<>(MemberLoginResponseDto.of(true));
            } else {
                return new BaseResponseDto<>(MemberLoginResponseDto.of(false));
            }
        }
    }
}
