package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPayment;
    private String type;
    @OneToOne(mappedBy = "payment")
    private Order order;
    
    public static final String DEBIT = "DEBITO A VISTA";
    public static final String CARTAO_CREDITO = "CARTAO DE CREDITO";
    public static final String MONEY = "DINHEIRO";

    public Payment() {
        this.type = MONEY;
    }

    public Payment(String type) {
        if(!type.equals(DEBIT) && !type.equals(CARTAO_CREDITO) && !type.equals(MONEY))
            throw new IllegalArgumentException("Tipo de pagamento inválido!");
        else    
            this.type = type;
    }

    public Integer getIdPayment() {
        return idPayment;
    }

    public void setIdPayment(Integer idPayment) {
        this.idPayment = idPayment;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
    
    public boolean pay(Double money){
        
        verifyException(money);
        
        return money >= order.getTotalValue();
    }    

    private void verifyException(Double money) {
        if(money < 0)
            throw new IllegalArgumentException("Numero invalido: < 0");
    }
    
    
}
