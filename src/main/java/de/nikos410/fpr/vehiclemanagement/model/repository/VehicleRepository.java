package de.nikos410.fpr.vehiclemanagement.model.repository;

import de.nikos410.fpr.vehiclemanagement.model.Vehicle;

import java.util.Collection;

/**
 * A repository for storing and accessing {@link Vehicle}s.
 */
public interface VehicleRepository extends Repository<Vehicle> {

    /**
     * Returns all elements in this repository with the given model number.
     *
     * @param modelNumber the model number of the elements to return.
     * @return a collection containing all matching elements in this repository.
     */
    Collection<Vehicle> findAllByModelNumber(String modelNumber);
}
