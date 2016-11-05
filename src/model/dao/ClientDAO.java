package model.dao;

import javax.persistence.EntityManager;
import model.Client;
import model.connection.ConnectionFactory;

public class ClientDAO {
    
    public void saveClient(Client client){
        EntityManager manager = new ConnectionFactory().getConnection();
        manager.getTransaction().begin();
        manager.merge(client);
        manager.getTransaction().commit();
        manager.close();
    }
}
