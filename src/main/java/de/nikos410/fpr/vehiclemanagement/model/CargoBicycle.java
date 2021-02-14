package de.nikos410.fpr.vehiclemanagement.model;

import java.math.BigDecimal;

public class CargoBicycle extends Vehicle {
    private BigDecimal cargoVolume;

    public BigDecimal getCargoVolume() {
        return cargoVolume;
    }

    public void setCargoVolume(BigDecimal cargoVolume) {
        this.cargoVolume = cargoVolume;
    }
}
