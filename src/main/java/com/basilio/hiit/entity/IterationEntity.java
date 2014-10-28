package com.basilio.hiit.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name = "Iteration")
@Entity
public class IterationEntity extends BaseEntity {

    @Column(nullable = false)
    private int cycles;

    @ManyToOne
    private ProgramEntity programEntity;

    @OneToMany(mappedBy = "iterationEntity")
    private Set<StepEntity> stepEntity;

    /**
     * @return the cycles
     */
    public int getCycles() {
        return this.cycles;
    }

    /**
     * @param cycles
     *            the cycles to set
     */
    public void setCycles(int cycles) {
        this.cycles = cycles;
    }

    public ProgramEntity getProgramEntity() {
        return programEntity;
    }

    public void setProgramEntity(ProgramEntity param) {
        this.programEntity = param;
    }

    public Set<StepEntity> getStepEntity() {
        return stepEntity;
    }

    public void setStepEntity(Set<StepEntity> param) {
        this.stepEntity = param;
    }
}
