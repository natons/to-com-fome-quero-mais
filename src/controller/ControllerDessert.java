package controller;

import java.util.ArrayList;
import java.util.List;
import model.Dessert;
import model.Product;
import model.Stock;
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
    
    public void save(String name, String price, String amount, String minimumAmount){
        Product product = new Product();
        product.setName(name);
        product.setPrice(Double.parseDouble(price));
        Stock stock = new Stock();
        stock.setAmount(Integer.parseInt(amount));
        stock.setMinimumAmount(Integer.parseInt(minimumAmount));
        product.setStock(stock);
        
        Dessert dessert = new Dessert();
        dessert.setProductDessert(product);
        
        new DessertDAO().save(dessert);
    }
}
