package com.doomsaj.bank_project_spring.domain.embeddeds.date_props;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DatePropertiesDTO {
    private LocalDate created_at;
    private LocalDate updated_at;
}
