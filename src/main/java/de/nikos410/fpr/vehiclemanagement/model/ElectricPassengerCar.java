package de.nikos410.fpr.vehiclemanagement.model;

import java.math.BigDecimal;
import java.text.MessageFormat;

public class ElectricPassengerCar extends PassengerCar {
    private final BigDecimal maximumRange;

    /**
     * Create a new instance using the given values.
     *
     * @param id the id that identifies this vehicle.
     * @param modelNumber the model number of this vehicle.
     * @param maximumSpeed the maximum speed of this vehicle in kilometres per hour (km/h).
     * @param numberOfSeats the number of seats of this vehicle.
     * @param maximumRange the maximum range of this car in kilometres (km).
     */
    public ElectricPassengerCar(long id, String modelNumber, BigDecimal maximumSpeed, int numberOfSeats, BigDecimal maximumRange) {
        super(id, modelNumber, maximumSpeed, numberOfSeats);
        this.maximumRange = maximumRange;
    }

    /**
     * Returns the maximum range of this car in kilometres (km).
     *
     * @return the maximum range of this car in kilometres (km).
     */
    protected BigDecimal getMaximumRange() {
        return maximumRange;
    }

    @Override
    public String toString() {
        return MessageFormat.format("ElectricPassengerCar'{'\nid={0}\nmodelNumber={1}\nmaximumSpeed={2}\nnumberOfSeats={3}\nmaximumRange={4}\n}",
                getId(),
                getModelNumber(),
                getMaximumSpeed(),
                getNumberOfSeats(),
                getMaximumRange());
    }
}
