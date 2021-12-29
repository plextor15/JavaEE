package model;

import javax.validation.constraints.*;

public class Hdd {
    private int id;
    private int id_product;
    
    @Positive(message = "Pole jest puste!")
    private int gb;

    @Positive(message = "Pole jest puste!")
    private int rpm;

    
    public int getGb() {
        return gb;
    }
    public void setGb(int gb) {
        this.gb = gb;
    }

    public int getRpm() {
        return rpm;
    }
    public void setRpm(int rpm) {
        this.rpm = rpm;
    }
}
