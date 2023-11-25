package org.sopt.sopkerton.program.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class ProgramDetailResponse {

    public record VolunteerDetail(
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
            @JsonProperty("isApply")
            boolean isApply
    ) {
    }

    public record EmploymentDetail(
            @JsonProperty("imageUrl")
            String imageUrl,
            @JsonProperty("content")
            String content,
            @JsonProperty("organizationName")
            String organizationName,
            @JsonProperty("registerAt")
            String registerAt,
            @JsonProperty("salary")
            int salary,
            @JsonProperty("isApply")
            boolean isApply
    ) {
    }
}
