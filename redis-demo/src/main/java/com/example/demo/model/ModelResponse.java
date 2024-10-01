package com.example.demo.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Builder
@ToString
@Getter
public class ModelResponse {
    private LocalDateTime timestamp;
    private Object data;
    private String result;
}