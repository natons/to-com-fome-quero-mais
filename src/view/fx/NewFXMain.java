/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.fx;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.fx.controller.ScreensController;

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
        ScreensController mainContainer = new ScreensController();
        mainContainer.loadScreen(loginId, loginFile);
        mainContainer.loadScreen(employeeId, employeeFile);
        
        mainContainer.setScreen(loginId);
        
        Group root = new Group();
        root.getChildren().addAll(mainContainer);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    
    public static void main(String[] args) {
        launch(args);
    }
    
}
