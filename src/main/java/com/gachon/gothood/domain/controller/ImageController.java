package com.gachon.gothood.domain.controller;

import com.gachon.gothood.domain.image.dto.FlaskResponseDto;
import com.gachon.gothood.domain.image.dto.ImageRateRequestDto;
import com.gachon.gothood.domain.image.dto.ImageRateResponseDto;
import com.gachon.gothood.domain.image.dto.ImageUploadResponseDto;
import com.gachon.gothood.domain.image.service.ImageService;
import com.gachon.gothood.global.response.BaseResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@ControllerAdvice
@RestController
@RequiredArgsConstructor
public class ImageController {
    private final ImageService imageService;

    @PostMapping("/image/rate")
    public BaseResponseDto<ImageRateResponseDto> rateFavorite(@RequestBody List<ImageRateRequestDto> requests) {
        return imageService.rate(requests);
    }

    @PostMapping("/image/recog")
    public BaseResponseDto<FlaskResponseDto> getRecognitionResult(
            @RequestPart("file") MultipartFile file
    ) {
        return new BaseResponseDto<>(imageService.getRecognitionResult(file));
    }

    @PostMapping("/image")
    public BaseResponseDto<ImageUploadResponseDto> uploadImage(@RequestPart MultipartFile multipartFile) {
        return new BaseResponseDto<>(imageService.uploadImage(multipartFile));
    }

}
