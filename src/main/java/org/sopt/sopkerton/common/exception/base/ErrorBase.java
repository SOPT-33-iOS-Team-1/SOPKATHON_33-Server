package org.sopt.sopkerton.common.exception.base;

import org.springframework.http.HttpStatus;

public interface ErrorBase extends RootEnum{
    int getHttpStatusCode();

    HttpStatus getHttpStatus();
    String getErrorMessage();
}
