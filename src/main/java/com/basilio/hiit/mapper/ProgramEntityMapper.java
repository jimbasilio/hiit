package com.basilio.hiit.mapper;

import org.springframework.stereotype.Component;

import com.basilio.hiit.dto.ProgramDTO;
import com.basilio.hiit.entity.ProgramEntity;

@Component
public class ProgramEntityMapper {

    public ProgramDTO toDTO(ProgramEntity entity) {
        ProgramDTO dto = new ProgramDTO();

        if (entity != null) {
            dto.setId(entity.getId());
            dto.setVersion(entity.getVersion());
            dto.setIterations(entity.getIterations());
            dto.setCreationDate(entity.getCreationDate());
            dto.setName(entity.getName());
            // this.setCreatedBy(entity.getCreatedBy());
        }

        return dto;
    }

    public ProgramEntity toEntity(ProgramEntity entity, ProgramDTO dto) {
        entity.setIterations(dto.getIterations());
        entity.setVersion(dto.getVersion());
        entity.setCreationDate(dto.getCreationDate());
        entity.setName(dto.getName());

        return entity;
    }
}
