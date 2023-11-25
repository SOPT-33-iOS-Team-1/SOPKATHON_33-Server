package org.sopt.sopkerton.program.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record ProgramListView(
        long programId,
        String title,
        String registerAt,
        String Region
) {

}
