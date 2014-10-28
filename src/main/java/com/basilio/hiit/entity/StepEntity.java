package com.basilio.hiit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "Step")
@Entity
public class StepEntity extends BaseEntity {
    @Column(nullable = false)
    private int durationInSeconds;

    @Column(nullable = false)
    private int reps;

    @ManyToOne
    private IterationEntity iterationEntity;

    public int getDurationInSeconds() {
        return durationInSeconds;
    }

    public void setDurationInSeconds(int durationInSeconds) {
        this.durationInSeconds = durationInSeconds;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public IterationEntity getIterationEntity() {
        return iterationEntity;
    }

    public void setIterationEntity(IterationEntity param) {
        this.iterationEntity = param;
    }

}
