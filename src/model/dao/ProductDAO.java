package model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import model.Product;
import model.connection.ConnectionFactory;

public class ProductDAO implements DAO<Product> {

    private static final String QUERY_FIND_ALL = "SELECT p FROM Product p";

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
    public void save(Product product) {
        EntityManager manager = new ConnectionFactory().getConnection();
        manager.getTransaction().begin();
        manager.merge(product);
        manager.getTransaction().commit();
        manager.close();
    }

    public void save(List<Product> products) {
        for (Product product : products) {
            EntityManager manager = new ConnectionFactory().getConnection();
            manager.getTransaction().begin();
            manager.merge(product);
            manager.getTransaction().commit();
            manager.close();
        }
    }

    @Override
    public List<Product> getAllElements() {
        EntityManager manager = new ConnectionFactory().getConnection();
        Query query = manager.createQuery(QUERY_FIND_ALL, Product.class);

        List<Product> products = null;
        try {
            products = (List<Product>) query.getResultList();
        } catch (NoResultException e) {
            System.out.println("Elementos não foram encontrados no BD!");
            return null;
        } finally {
            manager.close();
        }

        return products;
    }

}
