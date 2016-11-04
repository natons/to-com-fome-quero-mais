package model;

import java.util.List;
import javax.persistence.*;

@Entity
public class FormOfPayment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFormOfPayment;
    private String form;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "formOfPayment")
    @JoinColumn(name = "idFormOfPayment_FK")
    private List<Order> orders;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "FormOfPayment_Card",
            joinColumns = @JoinColumn(name = "idFormOfPayment_FK"),
            inverseJoinColumns = @JoinColumn(name = "idCard_FK"))
    private List<Card> cards;
    
    public static final String DEBIT = "Card Debit";
    public static final String CREDIT = "Card Credit";
    public static final String MONEY = "Money";

    public FormOfPayment() {
    }

    public FormOfPayment(Integer idFormOfPayment, String form, List<Order> orders, List<Card> cards) {
        this.idFormOfPayment = idFormOfPayment;
        this.form = form;
        this.orders = orders;
        this.cards = cards;
    }

    public Integer getIdFormOfPayment() {
        return idFormOfPayment;
    }

    public void setIdFormOfPayment(Integer idFormOfPayment) {
        this.idFormOfPayment = idFormOfPayment;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }
    
    
}
