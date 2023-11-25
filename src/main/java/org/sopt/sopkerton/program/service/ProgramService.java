package org.sopt.sopkerton.program.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.sopt.sopkerton.program.domain.Program;
import org.sopt.sopkerton.program.domain.Status;
import org.sopt.sopkerton.program.dto.response.ProgramListResponse;
import org.sopt.sopkerton.program.infrastructure.ProgramRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProgramService {
    private final ProgramRepository programRepository;

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

    private String formatToLocalDate(LocalDateTime localDateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM월 dd일");
        return localDateTime.format(formatter);
    }


}
