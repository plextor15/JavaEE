package model;

import javax.validation.constraints.*;

public class Gpu {
    private int id;
    private int id_product;
    
    @Positive(message = "Pole jest puste!")
    private double vramgb;
    
    @Positive(message = "Pole jest puste!")
    private int gddr;
    
    @Positive(message = "Pole jest puste!")
    private int mhz;

    
    public double getVramgb() {
        return vramgb;
    }
    public void setVramgb(double vramgb) {
        this.vramgb = vramgb;
    }

    public int getGddr() {
        return gddr;
    }
    public void setGddr(int gddr) {
        this.gddr = gddr;
    }

    public int getMhz() {
        return mhz;
    }
    public void setMhz(int mhz) {
        this.mhz = mhz;
    }
}
