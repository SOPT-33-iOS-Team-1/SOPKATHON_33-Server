package org.sopt.sopkerton.program.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ProgramListByProgramTypeRequest(
        @JsonProperty("program_type")
        String programType
) {
}
