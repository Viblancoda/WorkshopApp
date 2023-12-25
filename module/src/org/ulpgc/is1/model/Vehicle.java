package org.ulpgc.is1.model;

import java.util.ArrayList;
import java.util.List;

public class Vehicle {
    private String make;
    private String model;
    private Plate plate;
    private Customer customer;
    private List<Repair> repairs;

    public Vehicle(String make, String model, Plate plate, Customer customer) {
        this.make = make;
        this.model = model;
        this.plate = plate;
        this.customer = customer;
        this.repairs = new ArrayList();
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public Plate getPlate() {
        return plate;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPlate(Plate plate) {
        this.plate = plate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Repair getRepair(int i) {
        return (Repair)this.repairs.get(i);
    }

    public void addRepair(Repair repair) {
        this.repairs.add(repair);
    }
}
