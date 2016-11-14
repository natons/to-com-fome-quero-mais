package model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import model.Dish;
import model.connection.ConnectionFactory;

public class DishDAO implements DAO<Dish>{
    
    private static final String QUERY_FIND_ALL = "SELECT d FROM Dish d";
    private static final String QUERY_FIND = "SELECT d FROM Dish d WHERE d.product = :idProductFK";

    @Override
    public Dish findForObject(Dish dishReceived) {
        EntityManager manager = new ConnectionFactory().getConnection();
        Query query = manager.createQuery(QUERY_FIND, Dish.class)
                .setParameter("idProductFK", dishReceived.getProductDish().getIdProduct());
        
        Dish dish = null;
        try{
            dish = (Dish) query.getSingleResult();
        } catch (NoResultException e){
            System.out.println("Elemento não foi encontrado no BD!");
            return null;
        } finally {
            manager.close();
        }
                
        return dish;
    }

    @Override
    public Dish findById(Integer id) {
         EntityManager manager = new ConnectionFactory().getConnection();
         Dish dish = manager.find(Dish.class, id);
         manager.close();
         return dish;
    }

    @Override
    public void remove(Dish object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save(Dish dish) {
        EntityManager manager = new ConnectionFactory().getConnection();
        manager.getTransaction().begin();
        manager.merge(dish);
        manager.getTransaction().commit();
        manager.close();
    }

    @Override
    public List<Dish> getAllElements() {
        EntityManager manager = new ConnectionFactory().getConnection();
        Query query = manager.createQuery(QUERY_FIND_ALL, Dish.class);
        
        List<Dish> dishes = null;
        try{
            dishes = (List<Dish>) query.getResultList();
        } catch (NoResultException e){
            System.out.println("Elementos não foram encontrados no BD!");
            return null;
        } finally {
            manager.close();
        }
                
        return dishes;
    }
    
}
