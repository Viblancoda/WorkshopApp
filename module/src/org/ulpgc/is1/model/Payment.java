package org.ulpgc.is1.model;

import java.util.Date;

public class Payment {
    Date date;
    int amount;

    public Payment(Date date, int amount) {
        this.date = date;
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public int getAmount() {
        return amount;
    }
}
