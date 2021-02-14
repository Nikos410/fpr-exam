package de.nikos410.fpr.vehiclemanagement;

import de.nikos410.fpr.vehiclemanagement.model.*;
import de.nikos410.fpr.vehiclemanagement.model.repository.InMemoryVehicleRepository;
import de.nikos410.fpr.vehiclemanagement.model.repository.VehicleRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A basic command-line-interface (CLI) for managing different kinds of vehicles.
 */
public class VehicleManagementCLI implements AutoCloseable {
    private final BufferedReader bufferedStdInReader = new BufferedReader(new InputStreamReader(System.in));
    private final VehicleRepository vehicleRepository = new InMemoryVehicleRepository();

    public static void main(String[] args) throws IOException {
        try (final var vehicleManagementCLI = new VehicleManagementCLI()) {
            vehicleManagementCLI.run();
        }
    }

    /**
     * Start the CLI.
     */
    public void run() {
        boolean run;
        do {
            System.out.println("Please tell me what you want to do.");
            System.out.println("exit | list | find-by-id | find-by-model-number | add | remove");
            final String input = readLine();
            run = tryHandleCommand(input);
        } while (run);

        System.out.println("Goodbye.");
    }

    private boolean tryHandleCommand(String command) {
        try {
            return handleCommand(command);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return true;
        }
    }

    private boolean handleCommand(String command) {
        switch (command) {
            case "exit" -> {
                return false;
            }
            case "list" -> list();
            case "find-by-id" -> findById();
            case "find-by-model-number" -> findByModelNumber();
            case "add" -> tryAdd();
            case "remove" -> remove();
            default -> System.err.println("Unknown command. Please try again.");
        }

        return true;
    }

    private void list() {
        final String input = readLine("What should the vehicles be ordered by? [id | max-speed | cancel]");

        switch (input) {
            case "cancel" -> {
            }
            case "id" -> listOrderedById();
            case "max-speed" -> listOrderedByMaxSpeed();
            default -> {
                System.err.println("Unknown ordering. Please try again.");
                list();
            }
        }
    }

    private void listOrderedById() {
        final List<Vehicle> vehiclesOrderedById = vehicleRepository
                .findAll()
                .stream()
                .sorted()
                .collect(Collectors.toList());
        list(vehiclesOrderedById);
    }

    private void listOrderedByMaxSpeed() {
        final List<Vehicle> vehiclesOrderedByMaxSpeed = vehicleRepository
                .findAll()
                .stream()
                .sorted(Comparator.comparing(Vehicle::getMaximumSpeed))
                .collect(Collectors.toList());
        list(vehiclesOrderedByMaxSpeed);
    }

    private void findById() {
        try {
            final long id = Long.parseLong(readLine("Enter id."));
            final Vehicle vehicle = vehicleRepository
                    .findOneById(id)
                    .orElseThrow(() -> new IllegalArgumentException(MessageFormat.format("Vehicle with id {0} not found.", id)));
            System.out.println(vehicle);
        } catch (NumberFormatException e) {
            System.err.println("Invalid id. Please try again.");
            findById();
        }
    }

    private void findByModelNumber() {
        final String modelNumber = readLine("Enter model number.");
        final Collection<Vehicle> vehicles = vehicleRepository.findAllByModelNumber(modelNumber);
        list(vehicles);
    }

    private void list(Collection<Vehicle> vehicles) {
        System.out.println(MessageFormat.format("Found {0} vehicles.", vehicles.size()));
        System.out.println(vehicles
                .stream()
                .map(BaseEntity::toString)
                .collect(Collectors.joining(",\n")));
    }

    private void tryAdd() {
        try {
            add();
        } catch (NumberFormatException e) {
            System.err.println("Invalid number entered.");
        }
    }

    private void add() {
        final var id = Long.parseLong(readLine("Enter id."));
        final var modelNumber = readLine("Enter model number.");
        final var maximumSpeed = new BigDecimal(readLine("Enter maximum speed in kilometres per hour (km/h)."));

        final var type = readLine("What type of vehicle do you want to add? [passenger-car | cargo-bike]");

        switch (type) {
            case "passenger-car" -> addPassengerCar(id, modelNumber, maximumSpeed);
            case "cargo-bike" -> addCargoBicycle(id, modelNumber, maximumSpeed);
            default -> {
                System.err.println("Unknown vehicle type. Please try again.");
                add();
            }
        }

        System.out.println("Successfully added vehicle.");
    }

    private void addPassengerCar(long id, String modelNumber, BigDecimal maximumSpeed) {
        final var numberOfSeats = Integer.parseInt(readLine("Enter number of seats."));

        final var input = readLine("Is this vehicle an electric vehicle? [y|j|n]");
        final PassengerCar passengerCar;
        if (input.equalsIgnoreCase("y") || input.equalsIgnoreCase("j")) {
            final var maximumRange = new BigDecimal(readLine("Enter maximum range in kilometres (km)"));
            passengerCar = new ElectricPassengerCar(id, modelNumber, maximumSpeed, numberOfSeats, maximumRange);
        } else {
            passengerCar = new PassengerCar(id, modelNumber, maximumSpeed, numberOfSeats);
        }

        vehicleRepository.add(passengerCar);
    }

    private void addCargoBicycle(long id, String modelNumber, BigDecimal maximumSpeed) {
        final var cargoVolume = new BigDecimal(readLine("Enter cargo volume in cubic metres (m^3)."));

        final CargoBicycle cargoBicycle = new CargoBicycle(id, modelNumber, maximumSpeed, cargoVolume);
        vehicleRepository.add(cargoBicycle);
    }

    private void remove() {
        final String input = readLine("Enter id of vehicle to remove or cancel to return to main menu.");
        if (!input.equalsIgnoreCase("cancel")) {
            remove(input);
        }
    }

    private void remove(String vehicleIdInput) {
        try {
            final long vehicleId = Long.parseLong(vehicleIdInput);
            remove(vehicleId);
        } catch (NumberFormatException e) {
            System.err.println("Invalid vehicle id. Please try again.");
            remove();
        }
    }

    private void remove(long vehicleId) {
        vehicleRepository.remove(vehicleId);
        System.out.println("Successfully removed vehicle.");
    }

    private String readLine() {
        return readLine("");
    }

    private String readLine(String prompt) {
        if (!prompt.isBlank()) {
            System.out.println(prompt);
        }
        System.out.print("> ");

        try {
            return bufferedStdInReader.readLine();
        } catch (IOException e) {
            throw new IllegalStateException("Could not read input. Please try again.", e);
        }
    }

    @Override
    public void close() throws IOException {
        bufferedStdInReader.close();
    }
}
