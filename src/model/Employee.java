package model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
public class Employee {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEmployee;
    private String name;
    private String login;
    private String password;
    
    @ManyToMany(mappedBy = "employees")
    private List<Client> clients;
    
    public Employee() {
        clients = new ArrayList<>();
    }

    public Employee(Integer idEmployee, String name, String login, String password, List<Client> clients) {
        this.idEmployee = idEmployee;
        this.name = name;
        this.login = login;
        this.password = password;
        this.clients = clients;
    }

    public Employee(String login, String password) {
        this.login = login;
        this.password = password;
        clients = new ArrayList<>();
    }

    public Integer getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Integer idEmployee) {
        this.idEmployee = idEmployee;
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
    
    public void addClient(Client client){
        clients.add(client);
    }
    
    public void removeClient(Client client){
        clients.remove(client);
    }
    
    public void setClients(List<Client> clients){
        this.clients = clients;
    }
    
    public int getQuantityClients(){
        return clients.size();
    }

}
