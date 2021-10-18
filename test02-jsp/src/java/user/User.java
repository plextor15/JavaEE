package user;

public class User {
    private String username;
    private String password;
    
    public User(){
        username = "default";
        password = "password";
    }
    
    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username = username;
    }
    
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }
    
    public boolean sprawdzenie(){
        if(username.equals("admin") && password.equals("admin")){
            return true;
        }else{
            return false;
        }
    }
}