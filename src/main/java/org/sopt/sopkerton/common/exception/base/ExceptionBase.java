package org.sopt.sopkerton.common.exception.base;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * == 하위 도메인 예외는 본 Exception 클래스를 상속 받습니다.  ==
 */
@Getter
public class ExceptionBase extends RuntimeException{
    private static final String ERROR_MESSAGE_HEADER = "ERROR : ";

    private final ErrorBase errorBase;
    public ExceptionBase(ErrorBase errorBase) {
        super(ERROR_MESSAGE_HEADER + errorBase.getErrorMessage());
        this.errorBase = errorBase;
    }
    public HttpStatus getStatus() {
        return errorBase.getHttpStatus();
    }
}
