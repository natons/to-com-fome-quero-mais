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
import view.fx.controller.LoginScreenController;

/**
 *
 * @author natan
 */
public class LoginScreen extends Application{

    @Override
    public void start(Stage stage) throws Exception {
        
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("fxml/LoginScreenFXML.fxml"));
        Parent root = (Parent) loader.load();
        
        LoginScreenController controller = loader.getController();
        controller.setStage(stage);
        
        Scene scene = new Scene(root);
    
        stage.setTitle("Tela de Login");
        stage.setScene(scene);
        stage.show();
    }
    
}
