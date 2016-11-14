package test;

import controller.ControllerProduct;
import java.util.List;
import static junit.framework.TestCase.assertEquals;
import org.junit.Test;

public class Product{
    @Test
    public void getProducts() {
        List<model.Product> products = new ControllerProduct().getProducts(); 
        List<model.Product> productsResult = new ControllerProduct().getProducts(); 
        
        assertEquals(products, productsResult);
    }
}
