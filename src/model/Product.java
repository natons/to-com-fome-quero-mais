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
    
    @OneToOne(mappedBy = "productDessert")
    private Dessert dessert;
    
    @OneToOne(mappedBy = "productDrink")
    private Drink drink;
    
    @OneToOne(mappedBy = "productDish")
    private Dish dish;
    
    
    @OneToMany(mappedBy = "product")
    private List<Request> requests;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "IDSTOCK_FK")
    private Stock stock;
    
    
    public Product() {
    }

    public Product(Integer idProduct, String name, Double price, Dessert dessert, Drink drink, Dish dish, List<Request> requests, Stock stock) {
        this.idProduct = idProduct;
        this.name = name;
        this.price = price;
        this.dessert = dessert;
        this.drink = drink;
        this.dish = dish;
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
    
    public Request getLastRequest(){
        if(requests.isEmpty())
            return new Request();
        
        return requests.get(requests.size() - 1);
    }
}
