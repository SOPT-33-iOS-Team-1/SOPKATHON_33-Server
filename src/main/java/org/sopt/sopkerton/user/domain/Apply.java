package org.sopt.sopkerton.user.domain;

import jakarta.persistence.*;
import lombok.*;
import org.sopt.sopkerton.common.domain.BaseEntity;
import org.sopt.sopkerton.user.domain.enums.ApplyStatus;

@Getter
@Entity
@Table(schema = "skt-t1-app", name = "applies")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class Apply extends BaseEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "user_id", nullable = false)
    Long userId;

    @Column(name = "program_id", nullable = false)
    Long programId;

    @Column(name = "is_apply", nullable = false)
    @Enumerated(value = EnumType.STRING)
    ApplyStatus isApply;
}
