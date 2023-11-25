package org.sopt.sopkerton.user.domain.exception.apply;

import org.sopt.sopkerton.common.exception.base.ExceptionBase;

public class ApplyException extends ExceptionBase {
    public ApplyException(ApplyError errorBase) {
        super(errorBase);
    }
}
