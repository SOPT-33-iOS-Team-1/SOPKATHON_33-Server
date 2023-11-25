package org.sopt.sopkerton.program.domain;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.sopt.sopkerton.common.domain.BaseEntity;

@Getter
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "program_type")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "programs")
public abstract class Program extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "program_id")
    private Long id;

    @Column(nullable = false)
    private String title;

    private String imageUrl;
    private String type;
    @Enumerated(value = EnumType.STRING)
    private Status status;

    @Column(nullable = false)
    private String organizationName;

    @Column(nullable = false)
    private String region;

    @Column(nullable = false)
    private String content;
}
