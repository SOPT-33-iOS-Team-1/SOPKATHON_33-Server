package org.sopt.sopkerton.user.domain.exception;

import org.sopt.sopkerton.common.exception.base.ExceptionBase;

public class UserException extends ExceptionBase {
    public UserException(UserError userError) {
        super(userError);
    }
}
