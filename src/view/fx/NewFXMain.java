/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.fx;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.stage.Stage;
import model.Dish;
import model.Product;
import model.Stock;
import model.dao.DishDAO;

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
            /*
            ScreensController mainContainer = new ScreensController();
            mainContainer.loadScreen(loginId, loginFile);
            mainContainer.loadScreen(employeeId, employeeFile);
            
            mainContainer.setScreen(loginId);
            
            Group root = new Group();
            root.getChildren().addAll(mainContainer);
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();*/
            new LoginScreen().start(primaryStage);
            //testCadastros();
        } catch (Exception ex) {
            Logger.getLogger(NewFXMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    public static void main(String[] args) {
        launch(args);
    }

    private void testCadastros() {
        
        Dish dish = new Dish();
        Product product = new Product();
        product.setExpirationDate(new Date());
        product.setName("arroz com feijao");
        product.setPrice(20.0);
        Stock stock = new Stock();
        stock.setAmount(20);
        stock.setMinimumAmount(3);
        product.setStock(stock);
        dish.setProductDish(product);
        
        new DishDAO().save(dish);
    }
    
}
