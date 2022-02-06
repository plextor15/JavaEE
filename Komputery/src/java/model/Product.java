package model;

import javax.validation.constraints.*;

public class Product {
    private int id;
    
    @NotEmpty(message = "Pole jest puste!")
    private String name;
    
    @PositiveOrZero(message = "Pole jest puste!")
    private double price;
    
    @PositiveOrZero(message = "Pole jest puste!")
    private int amount;
    
    @PositiveOrZero(message = "Pole jest puste!")
    private int type;   // 0 - oth, 1 - CPU, 2 - RAM, 3 - GPU, 4 - HDD/SSD

    
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }


    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getAmount() { return amount; }
    public void setAmount(int amount) { this.amount = amount; }

    public int getType() { return type; }
    public void setType(int type) {
        if(type < 0) {
            this.type = 0;
        }
        
        if(type > 4) {
            this.type = 0;
        }
        else{
            this.type = type;
        }
    }
}
