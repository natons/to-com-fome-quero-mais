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
    private Integer id;
    private Integer DDD;
    private Integer number;
    @ManyToMany(mappedBy = "phones")
    private List<User> users;

    public Phone(Integer DDD, Integer number) {
        this.DDD = DDD;
        this.number = number;
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

    @Override
    public String toString() {
        return "Phone{" + "DDD=" + DDD + ", number=" + number + '}';
    }
    
    
    
    
}
