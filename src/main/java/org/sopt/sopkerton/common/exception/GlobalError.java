package org.sopt.sopkerton.common.exception;

import lombok.AllArgsConstructor;
import org.sopt.sopkerton.common.exception.base.ErrorBase;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
public enum GlobalError implements ErrorBase {

    ;

    private final HttpStatus status;
    private final String errorMessage;


    @Override
    public int getHttpStatusCode() {
        return status.value();
    }

    @Override
    public HttpStatus getHttpStatus() {
        return this.status;
    }


    @Override
    public String getErrorMessage() {
        return this.errorMessage;
    }

}
