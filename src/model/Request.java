package model;

import javax.persistence.*;

@Entity
class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRequest;
    private Integer quantity;
    @ManyToOne
    private Order order;
    @OneToOne(mappedBy = "request")
    private Product product;
    
    public Request() {
    }

    public Request(Integer idRequest, Integer quantity, Order order, Product product) {
        this.idRequest = idRequest;
        this.quantity = quantity;
        this.order = order;
        this.product = product;
    }

    public Integer getIdRequest() {
        return idRequest;
    }

    public void setIdRequest(Integer idRequest) {
        this.idRequest = idRequest;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    
    
}
