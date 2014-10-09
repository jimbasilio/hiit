package com.basilio.hiit.dto.display;

import java.time.LocalDate;

import com.basilio.hiit.entity.ProgramEntity;

public class ProgramGridDTO {
    private String name;
    private LocalDate creationDate;

    public ProgramGridDTO(ProgramEntity entity) {
        this.name = entity.getName();
        this.creationDate = entity.getCreationDate();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }
}
