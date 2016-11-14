package model;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity(name = "_ORDER")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idOrder;

    @Temporal(TemporalType.DATE)
    private Date dateOrder;

    private Double totalValue;
    private String observation;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "IDCLIENT_FK")
    private Client client;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "IDPAYMENT_FK")
    private Payment payment;
    
    @OneToMany(mappedBy = "order")
    private List<Dessert> desserts;
    
    @OneToMany(mappedBy = "order")
    private List<Dish> dishes;
    
    @OneToMany(mappedBy = "order")
    private List<Drink> drinks;

    public Order() {
    }

    public Order(Integer idOrder, Date dateOrder, Double totalValue, String observation, Client client, Payment payment, List<Dessert> desserts, List<Dish> dishes, List<Drink> drinks) {
        this.idOrder = idOrder;
        this.dateOrder = dateOrder;
        this.totalValue = totalValue;
        this.observation = observation;
        this.client = client;
        this.payment = payment;
        this.desserts = desserts;
        this.dishes = dishes;
        this.drinks = drinks;
    }

    public Integer getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Integer idOrder) {
        this.idOrder = idOrder;
    }

    public Date getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(Date dateOrder) {
        this.dateOrder = dateOrder;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public List<Dessert> getDesserts() {
        return desserts;
    }

    public void setDesserts(List<Dessert> desserts) {
        this.desserts = desserts;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    public List<Drink> getDrinks() {
        return drinks;
    }

    public void setDrinks(List<Drink> drinks) {
        this.drinks = drinks;
    }

    public void addDessert(Dessert dessert){
        desserts.add(dessert);
    }
    
    public void addDish(Dish dish){
        dishes.add(dish);
    }
    
    public void addDrink(Drink drink){
        drinks.add(drink);
    }
    

}
