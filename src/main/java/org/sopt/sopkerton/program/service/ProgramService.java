package org.sopt.sopkerton.program.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.sopt.sopkerton.program.domain.Program;
import org.sopt.sopkerton.program.domain.Status;
import org.sopt.sopkerton.program.domain.exception.ProgramError;
import org.sopt.sopkerton.program.domain.exception.ProgramException;
import org.sopt.sopkerton.program.dto.response.ProgramDetailResponse;
import org.sopt.sopkerton.program.dto.response.ProgramListResponse;
import org.sopt.sopkerton.program.infrastructure.ProgramRepository;
import org.sopt.sopkerton.user.domain.Apply;
import org.sopt.sopkerton.user.domain.enums.ApplyStatus;
import org.sopt.sopkerton.user.infrastructure.ApplyRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProgramService {
    private static final String VOLUNTEER_TYPE = "VOLUNTEERING";
    private static final String EMPLOYMENT_TYPE = "EMPLOYMENT";

    private final ProgramRepository programRepository;
    private final ApplyRepository applyRepository;

    public List<ProgramListResponse> getProgramListByProgramType(String programType) {
        List<Program> programs = programRepository.findAllByProgramType(programType);

        List<ProgramListResponse> programListResponses = programs.stream()
                .map(program -> new ProgramListResponse(
                        program.getId(),
                        program.getTitle(),
                        formatToLocalDate(program.getRegisterAt()),
                        program.getImageUrl(),
                        program.getStatus().getValue(),
                        program.getRegion()
                ))
                .collect(Collectors.toList());
        return programListResponses;
    }

    public List<ProgramListResponse> getStatusDoneProgramList() {
        List<Program> programs = programRepository.findAllByStatus(Status.DONE);

        List<ProgramListResponse> programListResponses = programs.stream()
                .map(program -> new ProgramListResponse(
                        program.getId(),
                        program.getTitle(),
                        formatToLocalDate(program.getRegisterAt()),
                        program.getImageUrl(),
                        program.getStatus().getValue(),
                        program.getRegion()
                ))
                .collect(Collectors.toList());
        return programListResponses;
    }

    public Object getProgramDetail(Long userId, Long programId) {
        Program program = programRepository.findById(programId)
                .orElseThrow(() -> new ProgramException(ProgramError.PROGRAM_NOT_FOUND));
        Apply apply = applyRepository.findByUserIdAndProgramId(userId, programId).get();
        boolean isApply = convertToIsApply(apply.getIsApply());
        if (program.getType().equals(VOLUNTEER_TYPE)) {
            return new ProgramDetailResponse.VolunteerDetail(
                    program.getImageUrl(),
                    program.getContent(),
                    program.getOrganizationName(),
                    formatToLocalDate(program.getRegisterAt()),
                    program.getVolunteerHours(),
                    isApply
            );
        }
        if (program.getType().equals(EMPLOYMENT_TYPE)){
            return new ProgramDetailResponse.EmploymentDetail(
                    program.getImageUrl(),
                    program.getContent(),
                    program.getOrganizationName(),
                    formatToLocalDate(program.getRegisterAt()),
                    program.getSalary(),
                    isApply
            );
        }
        return null;
    }

    private String formatToLocalDate(LocalDateTime localDateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM월 dd일");
        return localDateTime.format(formatter);
    }

    private boolean convertToIsApply(ApplyStatus status) {
        return status.equals(ApplyStatus.APPLY);
    }
}
