package org.ulpgc.is1.model;

public class Phone {
    String number;

    public boolean isValid(){
        if (number.matches("\\d{9}")) {
            return true;
        } else {
            number = "XXXX";
            return false;
        }
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
