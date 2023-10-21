package org.ulpgc.is1.model;

public class Vehicle {
    String make;
    String model;
    Plate plate;

    public Vehicle(String make, String model, Plate plate) {
        this.make = make;
        this.model = model;
        this.plate = plate;
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
}
