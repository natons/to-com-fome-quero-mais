package model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPhone;
    private Integer DDD;
    private Integer number;
    @ManyToMany(mappedBy = "phones")
    private List<User> users;

    public Phone() {
    }

    public Phone(Integer idPhone, Integer DDD, Integer number, List<User> users) {
        this.idPhone = idPhone;
        this.DDD = DDD;
        this.number = number;
        this.users = users;
    }

    public Integer getIdPhone() {
        return idPhone;
    }

    public void setIdPhone(Integer idPhone) {
        this.idPhone = idPhone;
    }

    public Integer getDDD() {
        return DDD;
    }

    public void setDDD(Integer DDD) {
        this.DDD = DDD;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
    
    
    
    
    
}
