package org.sopt.sopkerton.program.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("VOLUNTEERING")
@NoArgsConstructor
@AllArgsConstructor
public class Volunteering extends Program{
    private int volunteerHours;
}
