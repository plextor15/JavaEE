package BibliotekaPack;

/**
 *
 * @author UL0246827
 */
public class User {
    private String Username;
    private String Password;
    private String Id;
    public String Name;
    public String Surname;
    
    public User(){
        Username = "default";
        Password = "password";
    }
    
    public String getUsername(){
        return Username;
    }
    public void setUsername(String username){
        this.Username = username;
    }
    
    public String getPassword(){
        return Password;
    }
    public void setPassword(String password){
        this.Password = password;
    }
    
    public String getId(){
        return Id;
    }
    public void setId(String id){
        this.Id = id;
    }
}
