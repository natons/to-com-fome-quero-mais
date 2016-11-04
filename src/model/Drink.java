package model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="idProduct")
public class Drink extends Product{

    public Drink() {
    }

    public Drink(Integer idProduct, String name, Double price, Date expirationDate, Stock stock, Request request) {
        super(idProduct, name, price, expirationDate, stock, request);
    }
    
}
