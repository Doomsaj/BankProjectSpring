package com.doomsaj.bank_project_spring.domain.embeddeds.date_props;

public class DatePropertiesMapper {
    public static DatePropertiesDTO entityToDto(DateProperties entity) {
        return new DatePropertiesDTO(
                entity.getCreated_at(),
                entity.getUpdated_at()
        );
    }

    public static DateProperties dtoToEntity(DatePropertiesDTO dto) {
        return new DateProperties(
                dto.getCreated_at(),
                dto.getUpdated_at()
        );
    }
}
