package model;

import javax.validation.constraints.*;

public class Ram {
    private int id;
    private int id_product;
    
    @Positive(message = "Pole jest puste!")
    private int gb;

    @Positive(message = "Pole jest puste!")
    private int ddr;

    @Positive(message = "Pole jest puste!")
    private int mhz;

    
    public int getGb() {
        return gb;
    }
    public void setGb(int gb) {
        this.gb = gb;
    }

    public int getDdr() {
        return ddr;
    }
    public void setDdr(int ddr) {
        if(ddr < 0) {
            this.ddr = 0;
        }
        
        if(ddr > 7) {
            this.ddr = ddr;
        }
        else{
            this.ddr = 0;
        }
    }

    public int getMhz() {
        return mhz;
    }
    public void setMhz(int mhz) {
        this.mhz = mhz;
    }
}
