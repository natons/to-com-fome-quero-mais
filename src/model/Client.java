package model;

import java.util.List;
import javax.persistence.*;

@Entity
@PrimaryKeyJoinColumn(name="idClient")
public class Client extends User{
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Client_Card",
            joinColumns = @JoinColumn(name = "idClient_FK"),
            inverseJoinColumns = @JoinColumn(name = "idCard_FK"))
    private List<Card> cards;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Client_Order",
            joinColumns = @JoinColumn(name = "idClient_FK"),
            inverseJoinColumns = @JoinColumn(name = "idOrder_FK"))
    private List<Order> orders;

    public Client() {
    }

    public Client(List<Card> cards, List<Order> orders) {
        this.cards = cards;
        this.orders = orders;
    }

    public Client(List<Card> cards, List<Order> orders, Integer idUser, String name, String login, String password, Address address, List<Phone> phones) {
        super(idUser, name, login, password, address, phones);
        this.cards = cards;
        this.orders = orders;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
    
    
}
