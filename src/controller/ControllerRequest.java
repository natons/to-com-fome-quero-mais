/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.Request;
import model.dao.RequestDAO;

/**
 *
 * @author natan
 */
public class ControllerRequest {
    
    public void save(List<Request> requests){
        new RequestDAO().save(requests);
    }
}
