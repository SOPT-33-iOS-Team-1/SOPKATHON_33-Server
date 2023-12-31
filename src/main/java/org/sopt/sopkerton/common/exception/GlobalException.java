package org.sopt.sopkerton.common.exception;

import org.sopt.sopkerton.common.exception.base.ExceptionBase;

/**
 * 전역적 혹은 시스템 전체 범위에서 발생하는 예외
 */
public class GlobalException extends ExceptionBase {

    public GlobalException(GlobalError error) {
        super(error);
    }
}
