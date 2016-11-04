package mode.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import model.Client;
import model.connection.ConnectionFactory;

public class ClientDAO {
    
    public void saveClient(Client client){
        EntityManagerFactory emf = new ConnectionFactory().getConnection();
        EntityManager manager = emf.createEntityManager();
        manager.getTransaction().begin();
        manager.merge(client);
        manager.getTransaction().commit();
        manager.close();
        emf.close();
    }
}
