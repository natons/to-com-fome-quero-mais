package model;

import javax.persistence.*;

@Entity
public class Dish{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDish;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "IDORDER_FK")
    private Order order;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "IDPRODUCT_FK")
    private Product productDish;
    
    
    public Dish() {
    }

    public Dish(Integer idDish, Order order, Product product) {
        this.idDish = idDish;
        this.order = order;
        this.productDish = product;
    }

    public Integer getIdDish() {
        return idDish;
    }

    public void setIdDish(Integer idDish) {
        this.idDish = idDish;
    }

    public Product getProductDish() {
        return productDish;
    }

    public void setProductDish(Product productDish) {
        this.productDish = productDish;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
    
    
    
    
    
}
