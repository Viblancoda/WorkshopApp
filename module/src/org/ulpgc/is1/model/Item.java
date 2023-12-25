package org.ulpgc.is1.model;

public class Item {
    private int quantity;
    private SparePart sparePart;

    public Item(int quantity, SparePart sparePart) {
        this.quantity = quantity;
        this.sparePart = sparePart;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public SparePart getSparePart() {
        return sparePart;
    }

    public void setSparePart(SparePart sparePart) {
        this.sparePart = sparePart;
    }
}
