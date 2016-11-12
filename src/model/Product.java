package model;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProduct;
    
    private String name;
    private Double price;
    
    @Temporal(TemporalType.DATE)
    private Date expirationDate;
    
    @OneToOne(mappedBy = "product")
    private Dessert dessert;
    @OneToOne(mappedBy = "product")
    private Dish dish;
    @OneToOne(mappedBy = "product")
    private Drink drink;
    
    @OneToMany(mappedBy = "product")
    private List<Request> requests;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "IDSTOCK_FK")
    private Stock stock;
    
    
    public Product() {
    }

    public Product(Integer idProduct, String name, Double price, Date expirationDate, Dessert dessert, Dish dish, Drink drink, List<Request> requests, Stock stock) {
        this.idProduct = idProduct;
        this.name = name;
        this.price = price;
        this.expirationDate = expirationDate;
        this.dessert = dessert;
        this.dish = dish;
        this.drink = drink;
        this.requests = requests;
        this.stock = stock;
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

    public Dessert getDessert() {
        return dessert;
    }

    public void setDessert(Dessert dessert) {
        this.dessert = dessert;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public Drink getDrink() {
        return drink;
    }

    public void setDrink(Drink drink) {
        this.drink = drink;
    }

    public List<Request> getRequests() {
        return requests;
    }

    public void setRequests(List<Request> requests) {
        this.requests = requests;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }
    
    public void addRequest(Request request){
        requests.add(request);
    }
    
    public void removeRequest(Request request){
        requests.remove(request);
    }
    
    public int getQuantityRequest(){
        return requests.size();
    }
}
