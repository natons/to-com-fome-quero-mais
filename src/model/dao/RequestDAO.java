package model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import model.Request;
import model.connection.ConnectionFactory;

public class RequestDAO implements DAO<Request> {

    @Override
    public Request findForObject(Request object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Request findById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(Request object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save(Request object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void save(List<Request> requests) {
        for (Request request : requests) {
            EntityManager manager = new ConnectionFactory().getConnection();
            manager.getTransaction().begin();
            manager.merge(request);
            manager.getTransaction().commit();
            manager.close();
        }
    }

    @Override
    public List<Request> getAllElements() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
