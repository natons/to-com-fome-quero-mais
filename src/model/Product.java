package model;

import java.util.Date;
import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProduct;
    
    private String name;
    private Double price;
    
    @Temporal(TemporalType.DATE)
    private Date expirationDate;
    
    @ManyToOne
    private Stock stock;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idProduct_FK")
    private Request request;    
    
    public Product() {
    }

    public Product(Integer idProduct, String name, Double price, Date expirationDate, Stock stock, Request request) {
        this.idProduct = idProduct;
        this.name = name;
        this.price = price;
        this.expirationDate = expirationDate;
        this.stock = stock;
        this.request = request;
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }
    
    
}
