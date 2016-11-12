package model;

import javax.persistence.*;

@Entity
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idStock;
    private Integer amount;
    private Integer minimumAmount;
    
    @OneToOne(mappedBy = "stock")
    private Product product;

    public Stock() {
    }    

    public Stock(Integer idStock, Integer amount, Integer minimumAmount, Product product) {
        this.idStock = idStock;
        this.amount = amount;
        this.minimumAmount = minimumAmount;
        this.product = product;
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

    public Integer getMinimumAmount() {
        return minimumAmount;
    }

    public void setMinimumAmount(Integer minimumAmount) {
        this.minimumAmount = minimumAmount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    
    
}
