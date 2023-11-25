package org.sopt.sopkerton.user.service;

import lombok.RequiredArgsConstructor;
import org.sopt.sopkerton.user.domain.User;
import org.sopt.sopkerton.user.domain.enums.Gender;
import org.sopt.sopkerton.user.domain.exception.UserError;
import org.sopt.sopkerton.user.domain.exception.UserException;
import org.sopt.sopkerton.user.dto.response.MainView;
import org.sopt.sopkerton.user.infrastructure.UserRepository;
import org.springframework.stereotype.Service;

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
}
