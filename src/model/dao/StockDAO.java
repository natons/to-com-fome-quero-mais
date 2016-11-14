package model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import model.Stock;
import model.connection.ConnectionFactory;

public class StockDAO implements DAO<Stock>{

    @Override
    public Stock findForObject(Stock object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Stock findById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(Stock object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save(Stock stock) {
        EntityManager manager = new ConnectionFactory().getConnection();
        manager.getTransaction().begin();
        manager.merge(stock);
        manager.getTransaction().commit();
        manager.close();
    }

    @Override
    public List<Stock> getAllElements() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
