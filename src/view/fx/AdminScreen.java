package view.fx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.fx.controller.AdminScreenController;

public class AdminScreen extends Application{

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("fxml/AdminScreenFXML.fxml"));
        Parent root = (Parent) loader.load();
        
        AdminScreenController controller = loader.getController();
        controller.setStage(stage);
        
        Scene scene = new Scene(root);
    
        stage.setTitle("Tela de Administrador");
        stage.setScene(scene);
        stage.show();
    }
    
}
