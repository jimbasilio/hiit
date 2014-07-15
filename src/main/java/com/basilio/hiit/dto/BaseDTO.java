package com.basilio.hiit.dto;

public abstract class BaseDTO {
    protected Long id = -1L;
    protected Long version = -1L;

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

    public boolean isValidId() {
        return id > 0;
    }
}
