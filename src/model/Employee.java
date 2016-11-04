package model;

import java.util.List;
import javax.persistence.*;

@Entity
@PrimaryKeyJoinColumn(name="idClient")
public class Employee extends User{

    public Employee() {
    }

    public Employee(Integer idUser, String name, String login, String password, Address address, List<Phone> phones) {
        super(idUser, name, login, password, address, phones);
    }
    
}
