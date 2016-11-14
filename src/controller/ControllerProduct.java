package controller;

import java.util.List;
import model.Product;
import model.Stock;
import model.dao.ProductDAO;

public class ControllerProduct {
    
    public List<Product> getProducts(){
        return new ProductDAO().getAllElements();
    }

    public void save(List<Product> products) {
        new ProductDAO().save(products);
    }
    
    public void save(String name, String price, String amount, String minimumAmount){
        Product product = new Product();
        product.setName(name);
        product.setPrice(Double.parseDouble(price));
        Stock stock = new Stock();
        stock.setAmount(Integer.parseInt(amount));
        stock.setMinimumAmount(Integer.parseInt(minimumAmount));
        product.setStock(stock);
        
        new ProductDAO().save(product);
    }
}
