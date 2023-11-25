package org.sopt.sopkerton.common.response;

import lombok.RequiredArgsConstructor;

import org.sopt.sopkerton.common.exception.base.ErrorBase;
import org.sopt.sopkerton.common.exception.base.ExceptionBase;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@RequiredArgsConstructor
public class CommonControllerAdvice {

    @ExceptionHandler(value = ExceptionBase.class)
    public ResponseEntity<?> sopkathonExceptionHandler(ExceptionBase exception) {
        ErrorBase error = exception.getError();
        return ResponseEntity
                .status(error.getHttpStatus())
                .body(
                        ApiResponse.error(error)
                );
    }

}
