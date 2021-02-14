package de.nikos410.fpr.vehiclemanagement.model;

import java.math.BigDecimal;

/**
 * A cargo bicycle.
 */
public class CargoBicycle extends Vehicle {
    private BigDecimal cargoVolume;

    /**
     * Returns the cargo volume of this bike in cubic metres (m^3).
     *
     * @return the cargo volume of this bike in cubic metres (m^3).
     */
    public BigDecimal getCargoVolume() {
        return cargoVolume;
    }

    /**
     * Sets the cargo volume of this bike in cubic metres (m^3).
     *
     * @param cargoVolume the cargo volume of this bike in cubic metres (m^3).
     */
    public void setCargoVolume(BigDecimal cargoVolume) {
        this.cargoVolume = cargoVolume;
    }
}
