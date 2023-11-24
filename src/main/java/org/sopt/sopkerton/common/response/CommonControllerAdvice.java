package org.sopt.sopkerton.common.response;

import lombok.RequiredArgsConstructor;

import org.sopt.sopkerton.common.exception.base.ExceptionBase;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@RequiredArgsConstructor
public class CommonControllerAdvice {

    @ExceptionHandler(value = ExceptionBase.class)
    public ResponseEntity<?> sopkathonExceptionHandler(ExceptionBase exception) {
        return ResponseEntity
                .status(exception.getStatus())
                .body(
                        ApiResponse.error(exception.getErrorBase(), exception)
                );
    }

}
