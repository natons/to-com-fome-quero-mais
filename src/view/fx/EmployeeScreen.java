/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.fx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Employee;
import view.fx.controller.EmployeeScreenController;

/**
 *
 * @author natan
 */
public class EmployeeScreen extends Application{
    
    Employee employee;

    public EmployeeScreen() {
        employee = new Employee();
    }
    
    public EmployeeScreen(String login, String password){
        employee = new Employee(login, password);
    }

    @Override
    public void start(Stage stage) throws Exception {
        
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("fxml/EmployeeScreenFXML.fxml"));
        Parent root = (Parent) loader.load();
        
        EmployeeScreenController controller = loader.getController();
        controller.setEmployee(employee);
        
        Scene scene = new Scene(root);
    
        stage.setTitle("Tela de Login");
        stage.setScene(scene);
        stage.show();
    }
    
}
