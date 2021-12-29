package model;

import javax.validation.constraints.*;

public class Address {
    private int id;
    
    @NotEmpty(message = "Pole jest puste!")
    private String adres;

    @Positive(message = "Pole jest puste!")
    private int who;    //user id
    
    public String getAdres() {
        return adres;
    }
    public void setAdres(String adres) {
        this.adres = adres;
    }

    public int getWho() {
        return who;
    }
    public void setWho(int who) {
        this.who = who;
    }
}
