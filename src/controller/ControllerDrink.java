package controller;

import java.util.ArrayList;
import java.util.List;
import model.Drink;
import model.dao.DrinkDAO;

public class ControllerDrink {

    public ControllerDrink() {
    }
    
    public List<Drink> getAllElements(){
        List<Drink> drinks = new DrinkDAO().getAllElements();
        List<Drink> listAux = new ArrayList<>();
        
        drinks.forEach((drink) -> {
            if(drink.getProductDrink().getStock().getAmount() >= drink.getProductDrink().getStock().getMinimumAmount())
                listAux.add(drink);
        });
        
        return listAux;
    }
}
