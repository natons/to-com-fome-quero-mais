package model;

import java.util.List;
import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUser;
    private String name;
    private String login;
    private String password;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idAddress_FK")
    private Address address;
    @ManyToMany
    @JoinTable(name = "User_Phone",
            joinColumns = @JoinColumn(name = "idUser_FK"),
            inverseJoinColumns = @JoinColumn(name = "idPhone_FK"))
    private List<Phone> phones;

    public User() {
    }

    public User(Integer idUser, String name, String login, String password, Address address, List<Phone> phones) {
        this.idUser = idUser;
        this.name = name;
        this.login = login;
        this.password = password;
        this.address = address;
        this.phones = phones;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }
}
