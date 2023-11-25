package org.sopt.sopkerton.common.exception;

import lombok.AllArgsConstructor;
import org.sopt.sopkerton.common.exception.base.SuccessBase;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
public enum GlobalSuccess implements SuccessBase {
    ;

    private final HttpStatus status;
    private final String successMessage;


    @Override
    public int getHttpStatusCode() {
        return this.status.value();
    }

    @Override
    public HttpStatus getHttpStatus() {
        return this.status;
    }

    @Override
    public String getSuccessMessage() {
        return this.successMessage;
    }

}
