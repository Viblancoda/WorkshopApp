package org.ulpgc.is1.model;
import java.util.ArrayList;
import java.util.List;


public class RepairManager {
    private List<Mechanic> mechanics;
    private ArrayList<Vehicle> vehicles;
    private List<SparePart> spareParts;



    public RepairManager() {
        this.mechanics = new ArrayList<>();
        this.vehicles = new ArrayList<>();
        this.spareParts = new ArrayList<>();
    }

    public void addMechanic(String name, String surname) {
        Mechanic mechanic = new Mechanic(name, surname);
        mechanics.add(mechanic);
    }

    public void addVehicle(String make, String model, Plate plate) {
        Vehicle vehicle = new Vehicle(make, model, plate);
        vehicles.add(vehicle);
    }
    public void addSparePart(String name, int price){
        SparePart sparePart = new SparePart(name, price);
        spareParts.add(sparePart);

    }


    public void repair(Vehicle vehicle) {
        if (!vehicles.contains(vehicle)) {
            System.out.println("No se puede reparar el vehículo. El vehículo no está registrado.");
            return;
        }

        System.out.println("Reparando el vehículo: " + vehicle.getMake() + " " + vehicle.getModel());
    }

    public List<Mechanic> getMechanics() {
        return mechanics;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public List<SparePart> getSpareParts() { return spareParts; }
}