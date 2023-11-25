package org.sopt.sopkerton.user.domain.exception;

import lombok.AllArgsConstructor;
import org.sopt.sopkerton.common.exception.base.SuccessBase;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
public enum UserSuccess implements SuccessBase {
    USER_MAIN_VIEW_SUCCESS(HttpStatus.OK, "Get User Main View Data Successful."),
    USER_DETAIL_VIEW_SUCCESS(HttpStatus.OK, "Get User Detail View Data Successful.") ,
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
