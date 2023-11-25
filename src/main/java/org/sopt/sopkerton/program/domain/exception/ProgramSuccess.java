package org.sopt.sopkerton.program.domain.exception;

import lombok.AllArgsConstructor;
import org.sopt.sopkerton.common.exception.base.SuccessBase;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
public enum ProgramSuccess implements SuccessBase {
    PROGRAM_LIST_VIEW_SUCCESS(HttpStatus.OK, "Get Program List View Data Successful."),
    PROGRAM_DETAIL_VIEW_SUCCESS(HttpStatus.OK, "Get Program Detail View Data Successful.")
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
