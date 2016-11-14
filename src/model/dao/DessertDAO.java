package model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import model.Dessert;
import model.connection.ConnectionFactory;

public class DessertDAO implements DAO<Dessert>{
    
    private static final String QUERY_FIND_ALL = "SELECT d FROM Dessert d";

    @Override
    public Dessert findForObject(Dessert object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Dessert findById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(Dessert object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save(Dessert dessert) {
        EntityManager manager = new ConnectionFactory().getConnection();
        manager.getTransaction().begin();
        manager.merge(dessert);
        manager.getTransaction().commit();
        manager.close();
    }

    @Override
    public List<Dessert> getAllElements() {
        EntityManager manager = new ConnectionFactory().getConnection();
        Query query = manager.createQuery(QUERY_FIND_ALL, Dessert.class);
        
        List<Dessert> desserts = null;
        try{
            desserts = (List<Dessert>) query.getResultList();
        } catch (NoResultException e){
            System.out.println("Elementos não foram encontrados no BD!");
            return null;
        } finally {
            manager.close();
        }
                
        return desserts;
    }
    
}
