package org.sopt.sopkerton.program.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum Status {
    REGISTER("지원"),
    DONE("완료");

    private final String value;
}
