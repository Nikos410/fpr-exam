package de.nikos410.fpr.vehiclemanagement.model.repository;

import de.nikos410.fpr.vehiclemanagement.model.Vehicle;

import java.util.Collection;

public interface VehicleRepository extends Repository<Vehicle> {
    Collection<Vehicle> findAllByModelNumber(String modelNumber);
}
