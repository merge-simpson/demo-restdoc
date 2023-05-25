package com.example.demo.v1.api.dto;

import lombok.Builder;

@Builder
public record SampleResponseDto(
        Boolean success
) {
}
