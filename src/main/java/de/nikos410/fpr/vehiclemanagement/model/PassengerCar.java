package de.nikos410.fpr.vehiclemanagement.model;

import java.text.MessageFormat;

/**
 * A passenger car.
 */
public class PassengerCar extends Vehicle {
    private int numberOfSeats;

    /**
     * Returns the number of seats of this vehicle.
     *
     * @return the number of seats of this vehicle.
     */
    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    /**
     * Sets the number of seats of this vehicle.
     *
     * @param numberOfSeats the number of seats of this vehicle.
     */
    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    @Override
    public String toString() {
        return MessageFormat.format("ElectricPassengerCar{\nid={0}\nmodelNumber={1}\nmaximumSpeed={2}\nnumberOfSeets={3}\n}",
                getId(),
                getModelNumber(),
                getMaximumSpeed(),
                getNumberOfSeats());
    }
}
