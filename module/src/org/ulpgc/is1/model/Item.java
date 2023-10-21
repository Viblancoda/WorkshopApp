package org.ulpgc.is1.model;

public class Item {
    int quantity;
    Repair repair;
    SparePart sparePart;

    public Item(int quantity, Repair repair, SparePart sparePart) {
        this.quantity = quantity;
        this.repair = repair;
        this.sparePart = sparePart;
    }
    public Item(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Repair getRepair() {
        return repair;
    }

    public void setRepair(Repair repair) {
        this.repair = repair;
    }

    public SparePart getSparePart() {
        return sparePart;
    }

    public void setSparePart(SparePart sparePart) {
        this.sparePart = sparePart;
    }
}
