package org.sopt.sopkerton.user.infrastructure;


import org.sopt.sopkerton.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
