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

    /**
     * Indicates whether another vehicle is "equal to" this one. Vehicles are equal if they have the same id.
     *
     * Implemented according to Effective Java - 3rd edition, item 10.
     *
     * @param obj the reference object with which to compare.
     * @return true if this object has the same id as the obj argument; false otherwise.
     * @see BaseEntity
     * @see BaseEntity#getId()
     */
    @Override
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (!(obj instanceof Vehicle)) {
            return false;
        }

        final Vehicle vehicle = (Vehicle) obj;
        return getId() == vehicle.getId();
    }
}
