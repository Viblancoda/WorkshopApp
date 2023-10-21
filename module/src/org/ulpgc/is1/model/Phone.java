package org.ulpgc.is1.model;

public class Phone {
    String number;

    private boolean isValid(){
        return false;
    }

    public Phone(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
