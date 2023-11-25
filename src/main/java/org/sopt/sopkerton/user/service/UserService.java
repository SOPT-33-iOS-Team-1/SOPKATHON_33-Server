package org.sopt.sopkerton.user.service;

import lombok.RequiredArgsConstructor;
import org.sopt.sopkerton.user.domain.User;
import org.sopt.sopkerton.user.domain.enums.Gender;
import org.sopt.sopkerton.user.domain.exception.UserError;
import org.sopt.sopkerton.user.domain.exception.UserException;
import org.sopt.sopkerton.user.dto.response.DetailView;
import org.sopt.sopkerton.user.dto.response.MainView;
import org.sopt.sopkerton.user.infrastructure.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private static final String CRIMINAL_HISTORY = "단순 절도죄";
    private static final String CRIMINAL_HISTORY_DATE = "3년전";
    private static final String MALE = "남성";
    private static final String FEMALE = "여성";

    private static final int VOLUNTEER_HOURS = 50;
    private static final int COMPLETED_PROGRAM_COUNT = 4;
    private static final int CERTIFICATE_COUNT = 4;
    private static final double RING_RATE = 0.65;

    private final UserRepository userRepository;

    public MainView getMainViewInfo(Long userId) {
        User targetUser = userRepository.findById(userId)
                .orElseThrow(() -> new UserException(UserError.USER_NOT_FOUND));
        String gender;
        if (targetUser.getGender().equals(Gender.MALE)) {
            gender = MALE;
        } else {
            gender = FEMALE;
        }
        return new MainView(
                targetUser.getId(),
                targetUser.getThumbnail(),
                targetUser.getName(),
                gender,
                targetUser.getAge(),
                CRIMINAL_HISTORY,
                CRIMINAL_HISTORY_DATE,
                VOLUNTEER_HOURS,
                COMPLETED_PROGRAM_COUNT,
                CERTIFICATE_COUNT,
                RING_RATE
        );
    }

    public DetailView getDetailInfo(Long userId) {
        return new DetailView(
                makeVolunteers(),
                makeCompletedPrograms(),
                makeCertifications()
        );
    }


    private List<String> makeVolunteers() {
        return List.of(
                "어르신 생활편의 보조 도움",
                "백합요양원 어른신들 이미용봉사",
                "둘레길 환경정화 플로깅 활동",
                "용진읍 실로암병원 봉사활동"
        );
    }
    private List<String> makeCompletedPrograms() {
        return List.of(
                "사회성향상 프로그램",
                "직업훈련 프로그램",
                "면접지도 프로그램",
                "심리치료 프로그램"
        );
    }
    private List<String> makeCertifications() {
        return List.of(
                "지게차운전기능사",
                "농기계운전기능사",
                "건설기계설비기사",
                "산업안전산업기사"
        );
    }
}
