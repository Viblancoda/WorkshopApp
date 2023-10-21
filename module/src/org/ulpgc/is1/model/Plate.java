package org.ulpgc.is1.model;

public class Plate {
    String number;
    private boolean isValid(){
        return false;
    }

    public Plate(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

}
