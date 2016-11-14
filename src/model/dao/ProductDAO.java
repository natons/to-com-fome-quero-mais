package model.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import model.Product;
import model.connection.ConnectionFactory;

public class ProductDAO implements DAO<Product>{
    
    private static final String QUERY_FIND_ALL = "SELECT p FROM Product p INNER JOIN p.drink d";
    private static final String QUERY_FIND_ALL2 = "SELECT p FROM Product p INNER JOIN p.dish di";
    private static final String QUERY_FIND_ALL3= "SELECT p FROM Product p INNER JOIN p.dessert de";
    

    @Override
    public Product findForObject(Product object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Product findById(Integer id) {
        EntityManager manager = new ConnectionFactory().getConnection();
        Product product = manager.find(Product.class, id);
        manager.close();
        return product;
    }

    @Override
    public void remove(Product object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save(Product object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Product> getAllElements() {
        EntityManager manager = new ConnectionFactory().getConnection();
        Query queryDrink = manager.createQuery(QUERY_FIND_ALL, Product.class);
        Query queryDish = manager.createQuery(QUERY_FIND_ALL2, Product.class);
        Query queryDessert = manager.createQuery(QUERY_FIND_ALL3, Product.class);
        
        List<Product> productsDrink = null;
        List<Product> productsDish = null;
        List<Product> productsDessert = null;
        try{
            productsDrink = (List<Product>) queryDrink.getResultList();
            for(Product product : productsDrink){
                product.setDessert(null);
                product.setDish(null);
            }
            
            productsDish = (List<Product>) queryDish.getResultList();   
            for(Product product : productsDish){
                product.setDessert(null);
                product.setDrink(null);
            }
            
            productsDessert = (List<Product>) queryDessert.getResultList(); 
            for(Product product : productsDessert){
                product.setDrink(null);
                product.setDish(null);
            }
        } catch (NoResultException e){
            System.out.println("Elementos não foram encontrados no BD!");
            return null;
        } finally {
            manager.close();
        }
        
        List<Product> products = new ArrayList<>();
        products.addAll(productsDrink);
        products.addAll(productsDessert);
        products.addAll(productsDish);
        
        
        return products;
    }
    
}
