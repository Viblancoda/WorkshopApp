package org.ulpgc.is1.model;

public class Plate {
    private String number;
    public boolean isValid(String number) {
        return number != null && number.matches("^[0-9]{1,4}(?!.*(LL|CH))[BCDFGHJKLMNPRSTVWXYZ]{3}");
    }

    public Plate(String number) {
        if (this.isValid(number)) {
            this.number = number;
        } else {
            this.number = "Matrícula inválida";
        }

    }

    public String getPlate() {
        return number;
    }

}
