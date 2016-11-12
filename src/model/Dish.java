package model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
public class Dish{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDish;
    
    @OneToMany(mappedBy = "dish")
    private List<Order> orders;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "IDPRODUCT_FK")
    private Product product;
    
    public Dish() {
        orders = new ArrayList<>();
    }

    public Dish(Integer idDish, List<Order> orders, Product product) {
        this.idDish = idDish;
        this.orders = orders;
        this.product = product;
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

    public Integer getIdDish() {
        return idDish;
    }

    public void setIdDish(Integer idDish) {
        this.idDish = idDish;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    
    
    
}
