package org.sopt.sopkerton.program.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Entity
@DiscriminatorValue("EMPLOYMENT")
@NoArgsConstructor
@AllArgsConstructor
public class Employment extends Program{
    private int salary;
}
