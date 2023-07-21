package com.doomsaj.bank_project_spring.domain.embeddeds;

import jakarta.persistence.Embeddable;

import java.time.LocalDate;

@Embeddable
public class DateProperties {

    public DateProperties() {
    }

    public DateProperties(LocalDate created_at, LocalDate updated_at) {
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    private LocalDate created_at;
    private LocalDate updated_at;
}