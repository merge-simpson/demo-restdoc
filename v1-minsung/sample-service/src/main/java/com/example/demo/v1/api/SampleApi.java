package com.example.demo.v1.api;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class SampleApi {
    public record SampleRequestDto(@NotBlank String name, @NotNull @Min(0) Integer age) {
        public SampleRequestDto { name = name.strip(); }
    }
    @Builder
    public record SampleResponseDto(Boolean success) {}

    @PostMapping("/")
    public SampleResponseDto sample(@RequestBody @Valid SampleRequestDto body) {
        return SampleResponseDto.builder()
                .success(true)
                .build();
    }
}
