package de.nikos410.fpr.vehiclemanagement.model;

import java.math.BigDecimal;
import java.text.MessageFormat;

public class PassengerCar extends Vehicle {
    private final int numberOfSeats;

    /**
     * Create a new instance using the given values.
     *
     * @param id the id that identifies this vehicle.
     * @param modelNumber the model number of this vehicle.
     * @param maximumSpeed the maximum speed of this vehicle in kilometres per hour (km/h).
     * @param numberOfSeats the number of seats of this vehicle.
     */
    public PassengerCar(long id, String modelNumber, BigDecimal maximumSpeed, int numberOfSeats) {
        super(id, modelNumber, maximumSpeed);
        this.numberOfSeats = numberOfSeats;
    }

    protected int getNumberOfSeats() {
        return numberOfSeats;
    }

    @Override
    public String toString() {
        return MessageFormat.format("PassengerCar'{'\nid={0}\nmodelNumber={1}\nmaximumSpeed={2}\nnumberOfSeats={3}\n}",
                getId(),
                getModelNumber(),
                getMaximumSpeed(),
                getNumberOfSeats());
    }
}
