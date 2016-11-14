package view.fx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AdminScreen extends Application{

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("fxml/AdminScreenFXML.fxml"));
        Parent root = (Parent) loader.load();
        
        Scene scene = new Scene(root);
    
        stage.setTitle("Tela de Administrador");
        stage.setScene(scene);
        stage.show();
    }
    
}
