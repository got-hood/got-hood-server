package com.gachon.gothood.domain.image.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor(staticName = "of")
@Getter
@Setter
@Builder
public class ImageRegisterResponseDto {
    private String imageUrl;
    private Boolean gender;
}
