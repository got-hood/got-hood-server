package com.gachon.gothood.domain.image.service;

import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.gachon.gothood.domain.image.dto.FlaskResponseDto;
import com.gachon.gothood.domain.image.dto.ImageRateRequestDto;
import com.gachon.gothood.domain.image.dto.ImageRateResponseDto;
import com.gachon.gothood.domain.image.dto.ImageUploadResponseDto;
import com.gachon.gothood.global.response.BaseResponseDto;
import com.gachon.gothood.global.response.BusinessException;
import com.gachon.gothood.global.response.ErrorMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Slf4j
@Service
public class ImageService {

    private final S3Service s3Service;

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
    public FlaskResponseDto getRecognitionResult(MultipartFile file) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        try {
            body.add("file", new ByteArrayResource(file.getBytes()) {
                @Override
                public String getFilename() {
                    return file.getOriginalFilename();
                }
            });
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);

        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.postForEntity("http://localhost:5000/rekog", requestEntity, FlaskResponseDto.class).getBody();
    }

    public ImageUploadResponseDto uploadImage(MultipartFile multipartFile) {
        Optional<String> imgUrl;
        try {
            imgUrl = Optional.ofNullable(s3Service.upload(multipartFile));
        } catch (IOException | AmazonS3Exception e) {
            throw new BusinessException(ErrorMessage.INVALID_FILE_UPLOAD);
        }

        if (imgUrl.isPresent()) {
            return ImageUploadResponseDto.of(imgUrl.get());
        } else {
            throw new BusinessException(ErrorMessage.INVALID_FILE_UPLOAD);
        }
    }
}
