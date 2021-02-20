package de.nikos410.fpr.vehiclemanagement.model;

import java.math.BigDecimal;
import java.text.MessageFormat;

public class CargoBicycle extends Vehicle {
    private final BigDecimal cargoVolume;

    /**
     * Create a new instance using the given values.
     *
     * @param id the id that identifies this vehicle.
     * @param modelNumber the model number of this vehicle.
     * @param maximumSpeed the maximum speed of this vehicle in kilometres per hour (km/h).
     * @param cargoVolume the cargo volume of this bike in cubic metres (m^3).
     */
    public CargoBicycle(long id, String modelNumber, BigDecimal maximumSpeed, BigDecimal cargoVolume) {
        super(id, modelNumber, maximumSpeed);
        this.cargoVolume = cargoVolume;
    }

    /**
     * Returns the cargo volume of this bike in cubic metres (m^3).
     *
     * @return the cargo volume of this bike in cubic metres (m^3).
     */
    protected BigDecimal getCargoVolume() {
        return cargoVolume;
    }

    @Override
    public String toString() {
        return MessageFormat.format("CargoBicycle'{'\nid={0}\nmodelNumber={1}\nmaximumSpeed={2}\ncargoVolume={3}\n}",
                getId(),
                getModelNumber(),
                getMaximumSpeed(),
                getCargoVolume());
    }
}
