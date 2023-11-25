package org.sopt.sopkerton.program.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.sopt.sopkerton.program.domain.Program;
import org.sopt.sopkerton.program.dto.response.ProgramListResponse;
import org.sopt.sopkerton.program.infrastructure.ProgramRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProgramService {
    private final ProgramRepository programRepository;

    public List<ProgramListResponse> getProgramListByProgramType(String programType) {
        List<Program> programs = programRepository.findByProgramType(programType);

        // Program 엔티티를 ProgramListView로 변환
        List<ProgramListResponse> programListResponses = programs.stream()
                .map(program -> new ProgramListResponse(
                        program.getId(),
                        program.getTitle(),
                        formatToLocalDate(program.getRegisterAt()),
                        program.getRegion()
                ))
                .collect(Collectors.toList());
        return programListResponses;
    }

    private String formatToLocalDate(LocalDateTime localDateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM.dd");
        return localDateTime.format(formatter);
    }


}
