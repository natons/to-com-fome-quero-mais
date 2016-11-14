package model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import model.Client;
import model.connection.ConnectionFactory;

public class ClientDAO implements DAO<Client>{
    private static final String QUERY_FIND = "SELECT c FROM Client c WHERE c.nickname = :nickname";
    
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
    public Client findForObject(Client client) {
        EntityManager manager = new ConnectionFactory().getConnection();
        Query query = manager.createQuery(QUERY_FIND, Client.class);
        query.setParameter("nickname", client.getNickname());
        
        Client clientBD = null;
        try{
            clientBD = (Client) query.getSingleResult();
        } catch (NoResultException e){
            System.out.println("Objeto Employee não encontrado no BD!");
            return null;
        } finally {
            manager.close();
        }
        
        return clientBD;
    }

    @Override
    public List<Client> getAllElements() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
