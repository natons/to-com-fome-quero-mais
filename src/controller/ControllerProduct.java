package controller;

import java.util.List;
import model.Product;
import model.dao.ProductDAO;

public class ControllerProduct {
    
    public List<Product> getProducts(){
        return new ProductDAO().getAllElements();
    }

    public void save(List<Product> products) {
        new ProductDAO().save(products);
    }
}
