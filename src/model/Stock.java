package model;

import java.util.List;
import javax.persistence.*;

@Entity
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idStock;
    private Integer amount;
    private Integer minAmount;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stock")
    @JoinColumn(name = "idStock_FK")
    private List<Product> products;

    public Stock() {
    }

    public Stock(Integer idStock, Integer amount, Integer minAmount, List<Product> products) {
        this.idStock = idStock;
        this.amount = amount;
        this.minAmount = minAmount;
        this.products = products;
    }

    public Integer getIdStock() {
        return idStock;
    }

    public void setIdStock(Integer idStock) {
        this.idStock = idStock;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(Integer minAmount) {
        this.minAmount = minAmount;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
    
    
    
    
}
