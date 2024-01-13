package org.ulpgc.is1.model;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RepairManager {
    private final List<Mechanic> mechanicList = new ArrayList<>();
    private final List<Vehicle> vehicleList = new ArrayList<>();
    private final List<SparePart> sparePartList = new ArrayList<>();

    public List<Mechanic> getMechanicList() {
        return this.mechanicList;
    }

    public List<Vehicle> getVehicleList() {
        return this.vehicleList;
    }

    public List<SparePart> getSparePartList() {
        return this.sparePartList;
    }

    public void addMechanic(String name, String surname) {
        Mechanic mechanic = new Mechanic(name, surname);
        this.mechanicList.add(mechanic);
    }

    public Mechanic getMechanic(int i) {
        return this.mechanicList.get(i);
    }

    public void addVehicle(Vehicle vehicle) {
        this.vehicleList.add(vehicle);
    }

    public Vehicle getVehicle(int i) {
        return this.vehicleList.get(i);
    }

    public void addSparePart(SparePart sparePart) {
        this.sparePartList.add(sparePart);
    }

    public SparePart getSparePart(int i) {
        return this.sparePartList.get(i);
    }

    public void registerRepair(Mechanic mechanic, Vehicle vehicle, SparePart[] spareParts, BreakdownTypes breakdownType) {
        Repair repair = new Repair(new Date(), "Mechanical Repair", 5, vehicle, mechanic);
        for (SparePart sparePart : spareParts) {
            repair.addItem(1, sparePart);
        }
        repair.setBreakdownType(breakdownType);
        mechanic.addRepair(repair);
        vehicle.addRepair(repair);
    }

    public void removeVehicle(int i) {
        this.vehicleList.remove(i);
    }
}
