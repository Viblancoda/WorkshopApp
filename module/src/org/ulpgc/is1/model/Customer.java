package org.ulpgc.is1.model;

public class Customer {
    String name;
    Phone phone;

    public Customer(String name, Phone phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public Phone getPhone() {
        return phone;
    }
}
