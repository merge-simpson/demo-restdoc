package com.example.demo.v1.api;

import com.example.demo.v1.api.dto.SampleRequestDto;
import com.example.demo.v1.api.dto.SampleResponseDto;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class SampleApi {
    @PostMapping("/")
    public SampleResponseDto sample(@RequestBody @Valid SampleRequestDto body) {
        return SampleResponseDto.builder()
                .success(true)
                .build();
    }
}
