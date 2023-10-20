package org.ulpgc.is1.model;
import java.util.ArrayList;
import java.util.List;


public class RepairManager {
    private List<Mechanic> mechanics;
    private List<Vehicle> vehicles;

    public RepairManager() {
        this.mechanics = new ArrayList<>();
        this.vehicles = new ArrayList<>();
    }

    public void addMechanic(Mechanic mechanic) {
        mechanics.add(mechanic);
        System.out.println("Mecánico añadido: " + mechanic.getName());
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
        System.out.println("Vehículo añadido: " + vehicle.getMake() + " " + vehicle.getModel());
    }

    public void repair(Vehicle vehicle) {
        if (!vehicles.contains(vehicle)) {
            System.out.println("No se puede reparar el vehículo. El vehículo no está registrado.");
            return;
        }

        // Lógica para reparar el vehículo aquí.
        System.out.println("Reparando el vehículo: " + vehicle.getMake() + " " + vehicle.getModel());
    }

    public List<Mechanic> getMechanics() {
        return mechanics;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }
}