package de.nikos410.fpr.vehiclemanagement.model;

import java.math.BigDecimal;

/**
 * The base entity which all concrete vehicles should be based on.
 */
public abstract class Vehicle extends BaseEntity {
    private final String modelNumber;
    private final BigDecimal maximumSpeed;

    protected Vehicle(long id, String modelNumber, BigDecimal maximumSpeed) {
        super(id);
        this.modelNumber = modelNumber;
        this.maximumSpeed = maximumSpeed;
    }

    /**
     * Returns the model number of this vehicle.
     *
     * @return the model number of this vehicle.
     */
    public String getModelNumber() {
        return modelNumber;
    }

    /**
     * Returns the maximum speed of this vehicle in kilometres per hour (km/h).
     *
     * @return the maximum speed of this vehicle in kilometres per hour (km/h).
     */
    public BigDecimal getMaximumSpeed() {
        return maximumSpeed;
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
