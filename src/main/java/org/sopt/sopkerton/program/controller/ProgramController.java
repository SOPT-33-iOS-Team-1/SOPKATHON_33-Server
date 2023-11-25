package org.sopt.sopkerton.program.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.sopt.sopkerton.common.exception.ProgramSuccess;
import org.sopt.sopkerton.common.response.ApiResponse;
import org.sopt.sopkerton.program.dto.request.ProgramListRequest;
import org.sopt.sopkerton.program.dto.response.ProgramListResponse;
import org.sopt.sopkerton.program.service.ProgramService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/program")
public class ProgramController {
    private final ProgramService programService;

    @GetMapping("")
    public ResponseEntity<ApiResponse<List<ProgramListResponse>>> programListView(@RequestParam(name = "program_type") String type) {
        List<ProgramListResponse> programListByProgramType = programService.getProgramListByProgramType(type);
        return ResponseEntity
                .status(ProgramSuccess.PROGRAM_LIST_VIEW_SUCCESS.getHttpStatus())
                .body(
                        ApiResponse.success(ProgramSuccess.PROGRAM_LIST_VIEW_SUCCESS, programListByProgramType)
                );
    }
}
