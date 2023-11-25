package org.sopt.sopkerton.program.infrastructure;

import java.util.List;
import org.sopt.sopkerton.program.domain.Program;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgramRepository extends JpaRepository<Program, Long> {
    List<Program> findByProgramType(String programType);
}
