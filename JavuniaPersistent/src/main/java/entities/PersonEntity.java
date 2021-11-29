package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="persons")
public class PersonEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonEntity)) {
            return false;
        }
        PersonEntity other = (PersonEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    @Override
    public String toString() {
        return "entities.PersonEntity[ id=" + id + " ]";
    }
    
    
    private int Id;
    private String Name;
    private String Surname;
    private int Age;
    
    public int GetId() {
        return Id;
    }
    public void SetId(int Id) {
        this.Id = Id;
    }
    public String GetName() {
        return Name;
    }
    public void SetName(String Name) {
        this.Name = Name;
    }
    public String GetSurname() {
        return Surname;
    }
    public void SetSurname(String Surname) {
        this.Surname = Surname;
    }
    public int GetAge() {
        return Age;
    }
    public void SetAge(int Age) {
        this.Age = Age;
    }
}
