package org.sopt.sopkerton.program.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record ProgramListResponse(
        long programId,
        String title,
        String registerAt,
        String imageUrl,
        String status,
        String Region
) {

}
