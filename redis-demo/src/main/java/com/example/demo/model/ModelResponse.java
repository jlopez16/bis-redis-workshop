package com.example.demo.model;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ModelResponse {
    private LocalDateTime timestamp;
    private Object data;
    private String result;

    public ModelResponse(LocalDateTime timestamp, Object data, String result) {
        this.timestamp = timestamp;
        this.data = data;
        this.result = result;
    }

    @Override
    public String toString() {
        return "ModelResponse(timestamp=" + timestamp + ", data=" + data + ", result=" + result+")";
    }
}