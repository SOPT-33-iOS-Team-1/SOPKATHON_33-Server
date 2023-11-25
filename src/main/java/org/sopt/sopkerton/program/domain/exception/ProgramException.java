package org.sopt.sopkerton.program.domain.exception;

import org.sopt.sopkerton.common.exception.base.ExceptionBase;

public class ProgramException extends ExceptionBase {
    public ProgramException(ProgramError errorBase) {
        super(errorBase);
    }
}
