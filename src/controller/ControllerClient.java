package controller;

import model.Client;
import model.dao.ClientDAO;

public class ControllerClient {

    public void save(Client client) {
        new ClientDAO().save(client);
    }
    
    public Client exists(Client client){
        return new ClientDAO().findForObject(client);
    }
    
}
