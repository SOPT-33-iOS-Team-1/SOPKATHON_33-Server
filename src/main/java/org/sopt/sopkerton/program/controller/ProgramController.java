package org.sopt.sopkerton.program.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.sopt.sopkerton.program.domain.exception.ProgramSuccess;
import org.sopt.sopkerton.common.response.ApiResponse;
import org.sopt.sopkerton.program.dto.response.ProgramListResponse;
import org.sopt.sopkerton.program.service.ProgramService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/program")
public class ProgramController {
    private final ProgramService programService;

    @GetMapping("")
    public ResponseEntity<ApiResponse<List<ProgramListResponse>>> programListViewByProgramType(@RequestParam(name = "program_type") String type) {
        List<ProgramListResponse> programListByProgramType = programService.getProgramListByProgramType(type);
        return ResponseEntity
                .status(ProgramSuccess.PROGRAM_LIST_VIEW_SUCCESS.getHttpStatus())
                .body(
                        ApiResponse.success(ProgramSuccess.PROGRAM_LIST_VIEW_SUCCESS, programListByProgramType)
                );
    }

    @GetMapping("/register")
    public ResponseEntity<ApiResponse<List<ProgramListResponse>>> programListViewByStatus() {
        List<ProgramListResponse> programListByStatus = programService.getStatusDoneProgramList();
        return ResponseEntity
                .status(ProgramSuccess.PROGRAM_LIST_VIEW_SUCCESS.getHttpStatus())
                .body(
                        ApiResponse.success(ProgramSuccess.PROGRAM_LIST_VIEW_SUCCESS, programListByStatus)
                );
    }

    @GetMapping("/detail")
    public ResponseEntity<ApiResponse> orderProgramDetail(
            @RequestParam("programId") Long programId
    ) {
        Object programDetail = programService.getProgramDetail(1L, programId);
        return ResponseEntity
                .status(ProgramSuccess.PROGRAM_DETAIL_VIEW_SUCCESS.getHttpStatus())
                .body(
                        ApiResponse.success(ProgramSuccess.PROGRAM_DETAIL_VIEW_SUCCESS, programDetail)
                );
    }
}
