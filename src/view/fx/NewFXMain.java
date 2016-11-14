/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.fx;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author natan
 */
public class NewFXMain extends Application {
    
    public static String loginId = "main";
    public static String loginFile = "../fxml/LoginScreenFXML.fxml";
    
    public static String employeeId = "../fxml/employeeScreen";
    public static String employeeFile = "../fxml/EmployeeScreenFXML.fxml";
    
    @Override
    public void start(Stage primaryStage) {
        try {
            new LoginScreen().start(primaryStage);
        } catch (Exception ex) {
            Logger.getLogger(NewFXMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    public static void main(String[] args) {
        launch(args);
    }
    
}
