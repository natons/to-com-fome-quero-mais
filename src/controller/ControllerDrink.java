package controller;

import java.util.ArrayList;
import java.util.List;
import model.Drink;
import model.Product;
import model.Stock;
import model.dao.DrinkDAO;
import model.dao.ProductDAO;

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
    
    public void save(String name, String price, String amount, String minimumAmount){
        Product product = new Product();
        product.setName(name);
        product.setPrice(Double.parseDouble(price));
        Stock stock = new Stock();
        stock.setAmount(Integer.parseInt(amount));
        stock.setMinimumAmount(Integer.parseInt(minimumAmount));
        product.setStock(stock);
        
        Drink drink = new Drink();
        drink.setProductDrink(product);
        
        new DrinkDAO().save(drink);
    }
}
