package model;

import java.util.ArrayList;
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
public class Dessert{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDissert;
    
    @OneToMany(mappedBy = "dessert")
    private List<Order> orders;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "IDPRODUCT_FK")
    private Product product;

    public Dessert() {
        orders = new ArrayList<>();
    }

    public Dessert(Integer idDissert, List<Order> orders, Product product) {
        this.idDissert = idDissert;
        this.orders = orders;
        this.product = product;
    }

    public Integer getIdDissert() {
        return idDissert;
    }

    public void setIdDissert(Integer idDissert) {
        this.idDissert = idDissert;
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
