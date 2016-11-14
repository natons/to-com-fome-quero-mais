package model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Drink {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDrink;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "IDORDER_FK")
    private Order order;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "IDPRODUCT_FK")
    private Product productDrink;
    
    
    public Drink() {
    }

    public Drink(Integer idDrink, Order order, Product product) {
        this.idDrink = idDrink;
        this.order = order;
        this.productDrink = product;
    }

    public Integer getIdDrink() {
        return idDrink;
    }

    public void setIdDrink(Integer idDrink) {
        this.idDrink = idDrink;
    }

    public Product getProductDrink() {
        return productDrink;
    }

    public void setProductDrink(Product productDrink) {
        this.productDrink = productDrink;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

}
