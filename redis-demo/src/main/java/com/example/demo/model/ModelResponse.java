package com.example.demo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
public class ModelResponse implements Serializable {

    private LocalDateTime date;
    private Object response;
    private String message;

    public ModelResponse(LocalDateTime date, Object response, String message) {
        this.date = date;
        this.response = response;
        this.message = message;
    }

}
