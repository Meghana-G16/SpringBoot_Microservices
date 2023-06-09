package com.microservices.departmentService.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetails {

    private LocalDateTime localDateTime;
    private String message;
    private String path;
    private String errorCode;
}
