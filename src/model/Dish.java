package model;

import java.util.Date;
import javax.persistence.*;

@Entity
@PrimaryKeyJoinColumn(name="idProduct")
public class Dish extends Product{

    public Dish() {
    }

    public Dish(Integer idProduct, String name, Double price, Date expirationDate, Stock stock, Request request) {
        super(idProduct, name, price, expirationDate, stock, request);
    }
    
}
