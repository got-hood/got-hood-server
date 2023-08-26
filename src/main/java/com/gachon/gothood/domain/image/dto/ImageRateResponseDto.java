package com.gachon.gothood.domain.image.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor(staticName = "of")
@Getter
@Setter
@Builder
public class ImageRateResponseDto {
    private Long id;
    private String contents;
}
