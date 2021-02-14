package de.nikos410.fpr.vehiclemanagement.model;

import java.math.BigDecimal;

/**
 * An electric passenger car.
 */
public class ElectricPassengerCar extends PassengerCar {
    private BigDecimal maximumRange;

    /**
     * Returns the maximum range of this car.
     *
     * @return the maximum range of this car.
     */
    public BigDecimal getMaximumRange() {
        return maximumRange;
    }

    /**
     * Sets the maximum range of this car.
     *
     * @param maximumRange the maximum range of this car.
     */
    public void setMaximumRange(BigDecimal maximumRange) {
        this.maximumRange = maximumRange;
    }
}
