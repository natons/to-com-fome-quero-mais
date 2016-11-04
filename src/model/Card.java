package model;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCard;
    private Integer number;
    private Integer securityCode;
    @Temporal(TemporalType.DATE)
    private Date expirationDate;
    @ManyToMany(mappedBy = "cards")
    private List<Client> clients;
    @ManyToMany(mappedBy = "cards")
    private List<FormOfPayment> formOfPayments;

    public Card() {
    }

    public Card(Integer idCard, Integer number, Integer securityCode, Date expirationDate, List<Client> clients, List<FormOfPayment> formOfPayments) {
        this.idCard = idCard;
        this.number = number;
        this.securityCode = securityCode;
        this.expirationDate = expirationDate;
        this.clients = clients;
        this.formOfPayments = formOfPayments;
    }

    public Integer getIdCard() {
        return idCard;
    }

    public void setIdCard(Integer idCard) {
        this.idCard = idCard;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(Integer securityCode) {
        this.securityCode = securityCode;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public List<FormOfPayment> getFormOfPayments() {
        return formOfPayments;
    }

    public void setFormOfPayments(List<FormOfPayment> formOfPayments) {
        this.formOfPayments = formOfPayments;
    }
    
    
    
    
}
