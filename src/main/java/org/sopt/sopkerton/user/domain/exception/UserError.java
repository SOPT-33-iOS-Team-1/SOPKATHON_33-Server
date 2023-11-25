package org.sopt.sopkerton.user.domain.exception;

import lombok.AllArgsConstructor;
import org.sopt.sopkerton.common.exception.base.ErrorBase;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
public enum UserError implements ErrorBase {
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "Can not found User."),
    ;

    private final HttpStatus status;
    private final String errorMessage;


    @Override
    public int getHttpStatusCode() {
        return this.status.value();
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
