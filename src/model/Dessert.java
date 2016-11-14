package model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Dessert{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDissert;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "IDORDER_FK")
    private Order order;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "IDPRODUCT_FK")
    private Product productDessert;
    

    public Dessert() {
    }

    public Dessert(Integer idDissert, Order order, Product product) {
        this.idDissert = idDissert;
        this.order = order;
        this.productDessert = product;
    }


    public Integer getIdDissert() {
        return idDissert;
    }

    public void setIdDissert(Integer idDissert) {
        this.idDissert = idDissert;
    }

    public Product getProductDessert() {
        return productDessert;
    }

    public void setProductDessert(Product productDessert) {
        this.productDessert = productDessert;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
    
}
