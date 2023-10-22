package org.ulpgc.is1.model;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Repair {
    static int NEXT_ID = 0;
    final int id;
    Date date;
    String description;
    int effort;

    private List<Payment> payments;
    private List<Item> items;
    private BreakdownTypes breakdownType;

    public Repair(int NEXT_ID, int id, Date date, String description, int effort) {
        this.NEXT_ID = NEXT_ID;
        this.id = id;
        this.date = date;
        this.description = description;
        this.effort = effort;
        this.items = new ArrayList<>();
        this.payments = new ArrayList<>();
    }

    void addPayment(Date date, int amount){
        Payment payment = new Payment(date, amount);
        payments.add(payment);
    }

    public int price() {
        int totalPrice = 0;
        for (Item item : items) {
            totalPrice += item.getQuantity() * item.getSparePart().getPrice();
        }
        return totalPrice;
    }

    public int getNEXT_ID() {
        return NEXT_ID;
    }

    public int getId() {
        return id;
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

    public void setNEXT_ID(int NEXT_ID) {
        this.NEXT_ID = NEXT_ID;
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

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public BreakdownTypes getBreakdownType() {
        return breakdownType;
    }

    public void setBreakdownType(BreakdownTypes breakdownType) {
        this.breakdownType = breakdownType;
    }
}
