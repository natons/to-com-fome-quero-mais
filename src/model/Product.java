package model;

import java.util.Date;

public class Product {
    private String name;
    private Double price;
    private Date expirationDate;
    private Stock stock;

    public Product() {
    }
    
    public Product(String name, Double price, Date expirationDate, Stock stock) {
        this.name = name;
        this.price = price;
        this.expirationDate = expirationDate;
        this.stock = stock;
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
    
    public Stock getStock(){
        return stock;
    }
    
    public void setStock(Stock stock){
        this.stock = stock;
    }
    

    @Override
    public String toString() {
        return "Product{" + "name=" + name + ", price=" + price + ", expirationDate=" + expirationDate + '}';
    }
    
    
    
    
}
