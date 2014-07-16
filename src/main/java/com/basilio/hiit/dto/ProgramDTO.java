package com.basilio.hiit.dto;

import com.basilio.hiit.entity.ProgramEntity;

public class ProgramDTO {
    private Long id = -1L;
    private Long version = -1L;
    private long durationInSeconds = 0;
    private int iterations = 0;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
