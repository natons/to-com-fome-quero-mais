package model;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Drink {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDrink;
    
    @OneToMany(mappedBy = "drink")
    private List<Order> orders;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "IDPRODUCT_FK")
    private Product product;
    
    public Drink() {
    }

    public Drink(Integer idDrink, List<Order> orders, Product product) {
        this.idDrink = idDrink;
        this.orders = orders;
        this.product = product;
    }

    public Integer getIdDrink() {
        return idDrink;
    }

    public void setIdDrink(Integer idDrink) {
        this.idDrink = idDrink;
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

    
    
    public void addOrder(Order order){
        orders.add(order);
    }
    
    public void removeOrder(Order order){
        orders.remove(order);
    }
    
    public int getQuantityOrders(){
        return orders.size();
    }
    
}
