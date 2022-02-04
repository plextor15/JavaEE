package model;

import javax.validation.constraints.*;

public class User {
    private int id;
    
    @NotEmpty(message = "Pole jest puste!")
    private String username;
    
    @NotEmpty(message = "Pole jest puste!")
    private String password;
    
    @PositiveOrZero(message = "Pole jest puste!")
    private int type;   // 0 - guest, 1 - admin, 2 - user

    
    public User(){}
    public User(String username, String password){
        this.username = username;
        this.password = password;
        this.type = -1;
        this.id = -1;
    }
    public User(String username, String password, int id, int type){
        this.username = username;
        this.password = password;
        this.type = type;
        this.id = id;
    }

    
    @Override
    public String toString(){
        return this.username;
    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public int getType() {
        return type;
    }
    public void setType(int type) {
        if(type < 0) {
            this.type = 0;
        }
        
//        if(type > 3) {
            this.type = type;
//        }
//        else{
//            this.type = 0;
//        }
    }
}
