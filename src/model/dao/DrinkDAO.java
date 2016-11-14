package model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import model.Drink;
import model.connection.ConnectionFactory;

public class DrinkDAO implements DAO<Drink>{
    
    private static final String QUERY_FIND_ALL = "SELECT d FROM Drink d";
    
    @Override
    public Drink findForObject(Drink object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Drink findById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(Drink object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save(Drink drink) {
        EntityManager manager = new ConnectionFactory().getConnection();
        manager.getTransaction().begin();
        manager.merge(drink);
        manager.getTransaction().commit();
        manager.close();
    }

    @Override
    public List<Drink> getAllElements() {
        EntityManager manager = new ConnectionFactory().getConnection();
        Query query = manager.createQuery(QUERY_FIND_ALL, Drink.class);
        
        List<Drink> drinks = null;
        try{
            drinks = (List<Drink>) query.getResultList();
        } catch (NoResultException e){
            System.out.println("Elementos não foram encontrados no BD!");
            return null;
        } finally {
            manager.close();
        }
        
        return drinks;
    }
    
}
