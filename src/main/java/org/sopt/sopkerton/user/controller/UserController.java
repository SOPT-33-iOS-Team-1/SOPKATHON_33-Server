package org.sopt.sopkerton.user.controller;

import lombok.RequiredArgsConstructor;
import org.sopt.sopkerton.common.response.ApiResponse;
import org.sopt.sopkerton.user.domain.exception.UserSuccess;
import org.sopt.sopkerton.user.dto.response.MainView;
import org.sopt.sopkerton.user.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/info/{userId}")
    public ResponseEntity<ApiResponse<MainView>> orderMainView(
            @PathVariable("userId") Long userId
    ) {
        MainView mainViewInfo = userService.getMainViewInfo(userId);
        return ResponseEntity
                .status(UserSuccess.USER_MAIN_VIEW_SUCCESS.getHttpStatus())
                .body(
                        ApiResponse.success(UserSuccess.USER_MAIN_VIEW_SUCCESS, mainViewInfo)
                );
    }
}
