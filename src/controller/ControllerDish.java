package controller;

import java.util.ArrayList;
import java.util.List;
import model.Dish;
import model.Product;
import model.Stock;
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
    
    public void save(String name, String price, String amount, String minimumAmount){
        Product product = new Product();
        product.setName(name);
        product.setPrice(Double.parseDouble(price));
        Stock stock = new Stock();
        stock.setAmount(Integer.parseInt(amount));
        stock.setMinimumAmount(Integer.parseInt(minimumAmount));
        product.setStock(stock);
        
        Dish dish = new Dish();
        dish.setProductDish(product);
        
        new DishDAO().save(dish);
    }
}
