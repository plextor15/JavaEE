package model;

import javax.validation.constraints.*;

public class Cpu {
    private int id;
    private int id_product;
    
    @NotEmpty(message = "Pole jest puste!")
    private String name;
    
    @Positive(message = "Pole jest puste!")
    private double ghz;
    
    @Positive(message = "Pole jest puste!")
    private int cores;

    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public double getGhz() {
        return ghz;
    }
    public void setGhz(double ghz) {
        this.ghz = ghz;
    }

    public int getCores() {
        return cores;
    }
    public void setCores(int cores) {
        this.cores = cores;
    }
}
