package de.nikos410.fpr.vehiclemanagement.model;

import java.math.BigDecimal;
import java.text.MessageFormat;

/**
 * An electric passenger car.
 */
public class ElectricPassengerCar extends PassengerCar {
    private BigDecimal maximumRange;

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
