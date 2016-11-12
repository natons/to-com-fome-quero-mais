package model;

import java.util.Date;
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
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "IDDESSERT_FK")
    private Dessert dessert;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "IDDISH_FK")
    private Dish dish;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "IDDRINK_FK")
    private Drink drink;

    public Order() {
    }

    public Order(Integer idOrder, Date dateOrder, Double totalValue, String observation, Client client, Payment payment, Dessert dessert, Dish dish, Drink drink) {
        this.idOrder = idOrder;
        this.dateOrder = dateOrder;
        this.totalValue = totalValue;
        this.observation = observation;
        this.client = client;
        this.payment = payment;
        this.dessert = dessert;
        this.dish = dish;
        this.drink = drink;
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
    
    

}
