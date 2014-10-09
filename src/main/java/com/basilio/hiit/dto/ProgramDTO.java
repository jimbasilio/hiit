package com.basilio.hiit.dto;

import java.time.LocalDate;

import com.basilio.hiit.entity.ProgramEntity;

public class ProgramDTO extends BaseDTO {
    private int iterations = 0;
    private String name;
    private LocalDate creationDate;

    // private UserEntity createdBy;

    public ProgramDTO() {
        creationDate = LocalDate.now();
    }

    public ProgramDTO(ProgramEntity entity) {
        if (entity != null) {
            this.id = entity.getId();
            this.version = entity.getVersion();
            this.iterations = entity.getIterations();
            this.creationDate = entity.getCreationDate();
            this.name = entity.getName();
            // this.setCreatedBy(entity.getCreatedBy());
        }
    }

    /**
     * @return the iterations
     */
    public int getIterations() {
        return iterations;
    }

    /**
     * @param iterations
     *            the iterations to set
     */
    public void setIterations(int iterations) {
        this.iterations = iterations;
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
    //
    // public UserEntity getCreatedBy() {
    // return createdBy;
    // }
    //
    // public void setCreatedBy(UserEntity createdBy) {
    // this.createdBy = createdBy;
    // }

}
