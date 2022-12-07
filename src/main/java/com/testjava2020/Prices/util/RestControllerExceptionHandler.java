package com.testjava2020.Prices.util;


import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Collections;
import javax.persistence.EntityNotFoundException;

import com.testjava2020.Prices.dto.ApiResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ControllerAdvice
public class RestControllerExceptionHandler {

    @ExceptionHandler(value = {EntityNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    protected ResponseEntity<ApiResponseDTO<Object>> handleNotFound(EntityNotFoundException ex) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body(ApiResponseDTO.builder()
                .code(HttpStatus.NOT_FOUND.value())
                .message(HttpStatus.NOT_FOUND.getReasonPhrase())
                .error(Collections.singletonList(ex.getMessage()))
                .build()
            );
    }

    @ExceptionHandler(value = {SQLIntegrityConstraintViolationException.class})
    @ResponseStatus(HttpStatus.CONFLICT)
    protected ResponseEntity<ApiResponseDTO<Object>> handleRepeated(SQLIntegrityConstraintViolationException ex) {

        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(ApiResponseDTO.builder()
                        .code(HttpStatus.CONFLICT.value())
                        .message(HttpStatus.CONFLICT.getReasonPhrase())
                        .error(Collections.singletonList(ex.getMessage()))
                        .build()
                );
    }


}
