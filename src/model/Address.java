package model;

import java.util.List;
import javax.persistence.*;

@Entity
class Address {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String street;
    private Integer number;
    private String city;
    private String neighborhood;
    @OneToMany(mappedBy = "address")
    private List<User> users;

    public Address() {
    }

    public Address(Integer id, String street, Integer number, String city, String neighborhood, List<User> users) {
        this.id = id;
        this.street = street;
        this.number = number;
        this.city = city;
        this.neighborhood = neighborhood;
        this.users = users;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
    
    
}
