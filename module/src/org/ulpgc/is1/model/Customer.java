package org.ulpgc.is1.model;

public class Customer {
    String name;
    Phone pone;

    public Customer(String name, Phone pone) {
        this.name = name;
        this.pone = pone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Phone getPone() {
        return pone;
    }

    public void setPone(Phone pone) {
        this.pone = pone;
    }
}
