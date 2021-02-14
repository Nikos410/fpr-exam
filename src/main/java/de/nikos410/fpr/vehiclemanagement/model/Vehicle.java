package de.nikos410.fpr.vehiclemanagement.model;

public abstract class Vehicle extends BaseEntity {
    private String modelNumber;
    private String maximumSpeed;

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    public String getMaximumSpeed() {
        return maximumSpeed;
    }

    public void setMaximumSpeed(String maximumSpeed) {
        this.maximumSpeed = maximumSpeed;
    }
}
