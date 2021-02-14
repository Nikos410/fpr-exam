package de.nikos410.fpr.vehiclemanagement;

import de.nikos410.fpr.vehiclemanagement.model.BaseEntity;
import de.nikos410.fpr.vehiclemanagement.model.Vehicle;
import de.nikos410.fpr.vehiclemanagement.model.repository.InMemoryVehicleRepository;
import de.nikos410.fpr.vehiclemanagement.model.repository.VehicleRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class VehicleManagementCLI implements AutoCloseable {
    private final BufferedReader bufferedStdInReader = new BufferedReader(new InputStreamReader(System.in));
    private final VehicleRepository vehicleRepository = new InMemoryVehicleRepository();

    public static void main(String[] args) throws IOException {
        try (final var vehicleManagementCLI = new VehicleManagementCLI()) {
            vehicleManagementCLI.run();
        }
    }

    public void run() {
        boolean run;
        do {
            System.out.println("Please tell me what you want to do.");
            System.out.println("exit | list | add | remove");
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
            case "add" -> add();
            case "remove" -> remove();
            default -> System.err.println("Unknown command. Please try again.");
        }

        return true;
    }

    private void list() {
        final String input = readLine("What should the vehicles be ordered by? [id | max-speed | cancel]");

        switch (input) {
            case "cancel" -> {}
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

    private void list(List<Vehicle> vehicles) {
        System.out.println(vehicles
                .stream()
                .map(BaseEntity::toString)
                .collect(Collectors.joining(",\n")));
    }

    private void add() {
        // TODO
    }

    private void remove() {
        final String input = readLine("Enter id of vehicle to remove.");
        remove(input);
    }

    private void remove(String staffIdInput) {
        try {
            final long staffId = Long.parseLong(staffIdInput);
            remove(staffId);
        } catch (NumberFormatException e) {
            System.err.println("Invalid vehicle id. Please try again.");
            remove();
        }
    }

    private void remove(long staffId) {
        vehicleRepository.delete(staffId);
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
