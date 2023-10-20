package org.ulpgc.is1.model;
import java.util.Date;
public class Repair {
    int NEXT_ID = 0;
    final int id;
    Date date;
    String description;
    int effort;

    private double price(){
        return 0;
    }

    public Repair(int NEXT_ID, int id, Date date, String description, int effort) {
        this.NEXT_ID = NEXT_ID;
        this.id = id;
        this.date = date;
        this.description = description;
        this.effort = effort;
    }

    public int getNEXT_ID() {
        return NEXT_ID;
    }

    public void setNEXT_ID(int NEXT_ID) {
        this.NEXT_ID = NEXT_ID;
    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getEffort() {
        return effort;
    }

    public void setEffort(int effort) {
        this.effort = effort;
    }
}
