package org.ulpgc.is1.model;

public class Item {
    int quantity;
    Repair repair;
    SparePart sparePart;

    public Item(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
