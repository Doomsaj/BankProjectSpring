package com.doomsaj.bank_project_spring.domain.embeddeds.date_props;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Embeddable
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DateProperties {
    private LocalDate created_at;
    private LocalDate updated_at;
}