package de.nikos410.fpr.vehiclemanagement.model;

public abstract class BaseEntity {
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
