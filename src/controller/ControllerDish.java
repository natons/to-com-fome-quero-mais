package controller;

import java.util.ArrayList;
import java.util.List;
import model.Dish;
import model.dao.DishDAO;

public class ControllerDish {

    public ControllerDish() {
    }
    
    public List<Dish> getAllElements(){
        List<Dish> dishes = new DishDAO().getAllElements();
        List<Dish> listAux = new ArrayList<>();
        
        dishes.forEach((dish) -> {
            if(dish.getProductDish().getStock().getAmount() >= dish.getProductDish().getStock().getMinimumAmount())
                listAux.add(dish);
        });
        
        return listAux;
    }
}
