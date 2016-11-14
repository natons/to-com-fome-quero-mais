package model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import model.Client;
import model.connection.ConnectionFactory;

public class ClientDAO implements DAO<Client>{
    
    @Override
    public void save(Client client){
        EntityManager manager = new ConnectionFactory().getConnection();
        manager.getTransaction().begin();
        manager.merge(client);
        manager.getTransaction().commit();
        manager.close();
    }
    
    @Override
    public Client findById(Integer id) {
        EntityManager manager = new ConnectionFactory().getConnection();
        Client client = manager.find(Client.class, id);
        manager.close();
        return client;
    }

    @Override
    public void remove(Client object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Client findForObject(Client object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Client> getAllElements() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
