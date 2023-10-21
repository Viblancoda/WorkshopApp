package org.ulpgc.is1.model;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class RepairManager {
    private List<Mechanic> mechanics;
    private ArrayList<Vehicle> vehicles;
    private List<SparePart> spareParts;
    private List<Repair> repairs;



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
    public void addSparePart(String name, int price){
        SparePart sparePart = new SparePart(name, price);
        spareParts.add(sparePart);

    }
    public void addRepair(Repair repair) {
        repairs.add(repair);
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

    public void setMechanics(List<Mechanic> mechanics) {
        this.mechanics = mechanics;
    }

    public void setVehicles(ArrayList<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public void setSpareParts(List<SparePart> spareParts) {
        this.spareParts = spareParts;
    }

    public List<Repair> getRepairs() {
        return repairs;
    }

    public void setRepairs(List<Repair> repairs) {
        this.repairs = repairs;
    }
    public void formalizePayment(Repair repair, int paymentAmount) {
        if (repairs.contains(repair)) {
            Date paymentDate = new Date();
            Payment payment = new Payment(paymentDate, paymentAmount);

            repair.getPayments().add(payment);

            System.out.println("Pago formalizado por: " + repair.getId() + ". Precio: " + paymentAmount + "€");
        } else {
            System.out.println("No se encontró el pago");
        }
    }
    public void deleteVehicle(Vehicle vehicle) {
        if (vehicles.contains(vehicle)) {
            vehicles.remove(vehicle);
            System.out.println("Vehículo eliminado: " + vehicle.getMake() + " " + vehicle.getModel());
        } else {
            System.out.println("No se encontró vehículo para eliminar.");
        }
    }
    public int countVehicles() {
        return vehicles.size();
    }
}