package org.sopt.sopkerton.user.infrastructure;

import org.sopt.sopkerton.user.domain.Apply;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ApplyRepository extends JpaRepository<Apply, Long> {

    Optional<Apply> findByUserIdAndProgramId(Long userId, Long programId);
}
