package controller;

import java.util.ArrayList;
import java.util.List;
import model.Dessert;
import model.dao.DessertDAO;

public class ControllerDessert {

    public ControllerDessert() {
    }
    
    public List<Dessert> getAllElements(){
        List<Dessert> desserts = new DessertDAO().getAllElements();
        List<Dessert> listAux = new ArrayList<>();
        
        desserts.forEach((dessert) -> {
            if(dessert.getProductDessert().getStock().getAmount() >= dessert.getProductDessert().getStock().getMinimumAmount())
                listAux.add(dessert);
        });
        
        return listAux;
    }
}
