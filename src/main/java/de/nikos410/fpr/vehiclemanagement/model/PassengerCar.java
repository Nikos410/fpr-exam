package de.nikos410.fpr.vehiclemanagement.model;

import java.math.BigDecimal;
import java.text.MessageFormat;

/**
 * A passenger car.
 */
public class PassengerCar extends Vehicle {
    private int numberOfSeats;

    public PassengerCar(long id, String modelNumber, BigDecimal maximumSpeed, int numberOfSeats) {
        super(id, modelNumber, maximumSpeed);
        this.numberOfSeats = numberOfSeats;
    }

    /**
     * Returns the number of seats of this vehicle.
     *
     * @return the number of seats of this vehicle.
     */
    public int getNumberOfSeats() {
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
