package de.nikos410.fpr.vehiclemanagement.model;

import java.math.BigDecimal;

public class ElectricPassengerCar extends PassengerCar {
    private BigDecimal maximumRange;

    public BigDecimal getMaximumRange() {
        return maximumRange;
    }

    public void setMaximumRange(BigDecimal maximumRange) {
        this.maximumRange = maximumRange;
    }
}
