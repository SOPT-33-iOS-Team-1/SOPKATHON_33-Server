package org.sopt.sopkerton.user.dto.response;


public record MainView(
        long userId,
        String thumbnail,
        String name,
        String gender, // 남성 || 여성
        int age,
        String criminalHistory,
        String criminalHistoryDate,
        int volunteerHours,
        int completedProgramCount,
        int certificateCount,
        double ringRate
) {
}
