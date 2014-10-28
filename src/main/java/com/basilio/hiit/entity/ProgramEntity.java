package com.basilio.hiit.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import com.basilio.hiit.entity.UserEntity;
import javax.persistence.ManyToOne;

@Table(name = "Program")
@Entity
public class ProgramEntity extends BaseEntity {
    @Column(nullable = false)
    private int iterations;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalDate creationDate;

    @ManyToOne
    private UserEntity userEntity;

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

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity param) {
        this.userEntity = param;
    }

    // public UserEntity getCreatedBy() {
    // return createdBy;
    // }
    //
    // public void setCreatedBy(UserEntity createdBy) {
    // this.createdBy = createdBy;
    // }
}
