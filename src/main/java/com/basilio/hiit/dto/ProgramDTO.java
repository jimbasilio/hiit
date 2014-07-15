package com.basilio.hiit.dto;

import com.basilio.hiit.entity.ProgramEntity;

public class ProgramDTO extends BaseDTO {

    private long durationInSeconds = 0;
    private int iterations = 0;

    public ProgramDTO() {
    }

    public ProgramDTO(ProgramEntity entity) {
        if (entity != null) {
            this.id = entity.getId();
            this.version = entity.getVersion();
            this.durationInSeconds = entity.getDurationInSeconds();
            this.iterations = entity.getIterations();
        }
    }

    /**
     * @return the durationInSeconds
     */
    public long getDurationInSeconds() {
        return durationInSeconds;
    }

    /**
     * @param durationInSeconds
     *            the durationInSeconds to set
     */
    public void setDurationInSeconds(long durationInSeconds) {
        this.durationInSeconds = durationInSeconds;
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

}
