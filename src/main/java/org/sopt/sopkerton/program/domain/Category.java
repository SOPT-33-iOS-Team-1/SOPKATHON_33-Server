package org.sopt.sopkerton.program.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum Category {
    VOLUNTEERING("봉사"),
    EMPLOYMENT("취업");

    private final String value;
}
