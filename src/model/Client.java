package model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
public class Client{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idClient;
    private String name;
    private String nickname;
    
    @ManyToMany(mappedBy = "clients")
    private List<Employee> employees;
    
    @OneToMany(mappedBy = "client")
    private List<Order> orders;

    public Client() {
        employees = new ArrayList<>();
        orders = new ArrayList<>();
    }

    public Client(Integer idClient, String name, String nickname, List<Employee> employees, List<Order> orders) {
        this.idClient = idClient;
        this.name = name;
        this.nickname = nickname;
        this.employees = employees;
        this.orders = orders;
    }

    public Client(String name) {
        employees = new ArrayList<>();
        orders = new ArrayList<>();
        this.name = name;
    }

    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    
    public List<Employee> getEmployees() {
        return employees;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
    
    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public void addEmployee(Employee employee){
        employees.add(employee);
    }
    
    public void removeEmployee(Employee employee){
        employees.remove(employee);
    }
    
    public int getQuantityEmoloyees(){
        return employees.size();
    }
    
    public void addOrder(Order order){
        orders.add(order);
    }
    
    public void removeOrder(Order order){
        orders.remove(order);
    }
    
    public int getQuantityOrders(){
        return orders.size();
    }
    
    public Order getLastOrder(){
        if(orders.isEmpty())
            return new Order();
        
        return orders.get(orders.size() - 1);
    }
    
    
}
