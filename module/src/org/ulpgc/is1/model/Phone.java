package org.ulpgc.is1.model;

public class Phone {
    private String number;

    public Phone(String number) {
        if (this.isValid(number)) {
            this.number = number;
        } else {
            this.number = "XXXX";
        }

    }
    public boolean isValid(String number) {
        return number != null && number.matches("\\d{9}+");
    }

    public String getPhone() {
        return this.number;
    }
}
