package org.ulpgc.is1.model;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RepairManager {
    private final List<Mechanic> mechanics;
    private final List<Vehicle> vehicles;
    private final List<SparePart> spareParts;
    private final List<Repair> repairs;

    public RepairManager() {
        this.mechanics = new ArrayList<>();
        this.vehicles = new ArrayList<>();
        this.spareParts = new ArrayList<>();
        this.repairs = new ArrayList<>();
    }

    public void addMechanic(String name, String surname) {
        Mechanic mechanic = new Mechanic(name, surname);
        mechanics.add(mechanic);
    }

    public void addVehicle(String make, String model, Plate plate, Customer customer) {
        Vehicle vehicle = new Vehicle(make, model, plate, customer);
        vehicles.add(vehicle);
    }

    public void addSparePart(String name, int price) {
        SparePart sparePart = new SparePart(name, price);
        spareParts.add(sparePart);
    }

    public void addRepair(Repair repair) {
        repairs.add(repair);
    }

    public List<Mechanic> getMechanics() {
        return mechanics;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public List<SparePart> getSpareParts() {
        return spareParts;
    }

    public List<Repair> getRepairs() {
        return repairs;
    }
    public Repair getRepair(int i) {
        return (Repair)this.repairs.get(i);
    }

    public void formalizePayment(Repair repair, int paymentAmount) {
        if (repairs.contains(repair)) {
            Payment payment = new Payment(Date.from(Instant.now()), paymentAmount);
            repair.addPayment(payment);
            System.out.println("Pago formalizado por ID:"  + ". Precio: " + paymentAmount + "€");
        } else {
            System.out.println("No se encontró la reparación para realizar el pago.");
        }
    }

    public void deleteVehicle(Vehicle vehicle) {
        if (vehicles.contains(vehicle)) {
            vehicles.remove(vehicle);
            System.out.println("Vehículo eliminado: " + vehicle.getMake() + " " + vehicle.getModel());
        } else {
            System.out.println("No se encontró el vehículo para eliminar.");
        }
    }

    public int countVehicles() {
        return vehicles.size();
    }

    public int calculateRepairCost(Repair repair) {
        int totalCost = 0;
        for (Item item : repair.getItems()) {
            totalCost += item.getSparePart().getPrice() * item.getQuantity();
        }
        return totalCost;
    }
}}