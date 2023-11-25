package org.sopt.sopkerton.user.domain;

import jakarta.persistence.*;
import lombok.*;
import org.sopt.sopkerton.user.domain.enums.Gender;

@Getter
@Entity
@Table(schema = "skt-t1-app", name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "name", nullable = false)
    String name;

    @Column(name = "gender", nullable = false)
    @Enumerated(value = EnumType.STRING)
    Gender gender;

    @Column(name = "thumbnail")
    String thumbnail;

    @Column(name = "age", nullable = false)
    int age;

}
