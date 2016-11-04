package model;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity(name = "_Order")
class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idOrder;

    @Temporal(TemporalType.DATE)
    private Date dateOrder;

    private Double totalValue;
    private String observation;

    @ManyToMany(mappedBy = "orders")
    private List<Client> clients;

    @ManyToOne
    private FormOfPayment formOfPayment;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    @JoinColumn(name = "idOrder_FK")
    private List<Request> requests;

    public Order() {
    }

    public Order(Integer idOrder, Date dateOrder, Double totalValue, String observation, List<Client> clients, FormOfPayment formOfPayment, List<Request> requests) {
        this.idOrder = idOrder;
        this.dateOrder = dateOrder;
        this.totalValue = totalValue;
        this.observation = observation;
        this.clients = clients;
        this.formOfPayment = formOfPayment;
        this.requests = requests;
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

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public FormOfPayment getFormOfPayment() {
        return formOfPayment;
    }

    public void setFormOfPayment(FormOfPayment formOfPayment) {
        this.formOfPayment = formOfPayment;
    }

    public List<Request> getRequests() {
        return requests;
    }

    public void setRequests(List<Request> requests) {
        this.requests = requests;
    }

}
