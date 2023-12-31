package org.ulpgc.is1.model;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Repair {
    private static int NEXT_ID = 0;
    private final int id;
    private Date date;
    private String description;
    private int effort;
    private List<Payment> payments;
    private List<Item> items;
    private BreakdownTypes breakdownType;
    private Vehicle vehicle;
    private Mechanic mechanic;

    public Repair(Date date, String description, int effort, Vehicle vehicle, Mechanic mechanic) {
        this.id = NEXT_ID;
        this.date = date;
        this.description = description;
        this.effort = effort;
        this.items = new ArrayList<>();
        this.payments = new ArrayList<>();
        this.mechanic = mechanic;
        this.vehicle = vehicle;
    }

    public void addPayment(Payment payment){
        this.payments.add(payment);
    }
    void addItem(int quantity, SparePart sparePart){
        Item item = new Item(quantity, sparePart);
        this.items.add(item);
    }

    public int price() {
        int totalPrice = 0;
        for (Item item : items) {
            totalPrice += item.getQuantity() * item.getSparePart().getPrice();
        }
        return totalPrice;
    }

    public Date getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public int getEffort() {
        return effort;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEffort(int effort) {
        this.effort = effort;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public List<Item> getItems() {
        return items;
    }

    public BreakdownTypes getBreakdownType() {
        return breakdownType;
    }

    public void setBreakdownType(BreakdownTypes breakdownType) {
        this.breakdownType = breakdownType;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Mechanic getMechanic() {
        return mechanic;
    }

    public void setMechanic(Mechanic mechanic) {
        this.mechanic = mechanic;
    }
}
