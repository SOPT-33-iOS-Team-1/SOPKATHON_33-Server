package org.sopt.sopkerton.program.infrastructure;

import java.util.List;
import org.sopt.sopkerton.program.domain.Program;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProgramRepository extends JpaRepository<Program, Long> {

    @Query("select p from Program p where p.type = :type order by p.registerAt")
    List<Program> findAllByProgramType(@Param("type")String programType);
}
