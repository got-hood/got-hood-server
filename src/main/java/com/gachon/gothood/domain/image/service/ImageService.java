package com.gachon.gothood.domain.image.service;

import com.gachon.gothood.domain.image.dto.ImageRateRequestDto;
import com.gachon.gothood.domain.image.dto.ImageRateResponseDto;
import com.gachon.gothood.global.response.BaseResponseDto;
import com.gachon.gothood.global.response.BusinessException;
import com.gachon.gothood.global.response.ErrorMessage;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class ImageService {

    public BaseResponseDto<ImageRateResponseDto> rate(List<ImageRateRequestDto> requests) {
        Optional<ImageRateRequestDto> maxRate = requests.stream()
                .max(Comparator.comparingDouble(ImageRateRequestDto::getRate));
        if (maxRate.isEmpty()) {
            throw new BusinessException(ErrorMessage.WRONG_POST);
        }

        ImageRateRequestDto favoriteGirl = maxRate.get();
        Long favoriteGirlId = favoriteGirl.getId();
        // 파이썬 서버에 이미지 보내기
        // 받은 내용을 담기
        String contents = "good!";
        return new BaseResponseDto<>(ImageRateResponseDto.of(favoriteGirlId, contents));
    }
}
