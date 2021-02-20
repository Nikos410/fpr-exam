package de.nikos410.fpr.vehiclemanagement.repository;

import de.nikos410.fpr.vehiclemanagement.model.Vehicle;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * A basic {@link VehicleRepository} implementation that keeps data in memory and does not persist anything.
 */
public class InMemoryVehicleRepository extends InMemoryRepository<Vehicle> implements VehicleRepository {
    @Override
    public Collection<Vehicle> findAllByModelNumber(String modelNumber) {
        return content.stream()
                .filter(vehicle -> modelNumber.equals(vehicle.getModelNumber()))
                .collect(Collectors.toList());
    }
}
