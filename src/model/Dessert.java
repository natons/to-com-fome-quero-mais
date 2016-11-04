package model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="idProduct")
public class Dessert extends Product{

    public Dessert() {
    }

    public Dessert(Integer idProduct, String name, Double price, Date expirationDate, Stock stock, Request request) {
        super(idProduct, name, price, expirationDate, stock, request);
    }
    
    
}
