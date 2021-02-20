package de.nikos410.fpr.vehiclemanagement.model;

import java.math.BigDecimal;

/**
 * The base entity for all concrete vehicles types.
 */
public abstract class Vehicle extends BaseEntity {
    private final String modelNumber;
    private final BigDecimal maximumSpeed;

    /**
     * Create a new instance using the given values.
     *
     * @param id the id that identifies this vehicle.
     * @param modelNumber the model number of this vehicle.
     * @param maximumSpeed the maximum speed of this vehicle in kilometres per hour (km/h).
     */
    protected Vehicle(long id, String modelNumber, BigDecimal maximumSpeed) {
        super(id);
        this.modelNumber = modelNumber;
        this.maximumSpeed = maximumSpeed;
    }

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
