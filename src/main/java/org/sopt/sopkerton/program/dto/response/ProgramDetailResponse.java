package org.sopt.sopkerton.program.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ProgramDetailResponse (
        @JsonProperty("title")
        String title,
        @JsonProperty("imageUrl")
        String imageUrl,
        @JsonProperty("content")
        String content,
        @JsonProperty("organizationName")
        String organizationName,
        @JsonProperty("registerAt")
        String registerAt,
        @JsonProperty("hour")
        int hour,
        @JsonProperty("salary")
        int salary,
        @JsonProperty("isApply")
        boolean isApply,
        @JsonProperty("programType")
        String type
){

}
