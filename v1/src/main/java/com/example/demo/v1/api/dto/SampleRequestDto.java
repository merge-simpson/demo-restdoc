package com.example.demo.v1.api.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record SampleRequestDto(
        @NotBlank String name,
        @NotNull @Min(0) Integer age
) {
    public SampleRequestDto {
        name = name.strip();
    }
}
