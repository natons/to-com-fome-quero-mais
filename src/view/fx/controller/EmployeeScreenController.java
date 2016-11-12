package view.fx.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

public class EmployeeScreenController implements Initializable, ControlledScreen{
    
    ScreensController myController;
    
    public EmployeeScreenController() {
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }

    @Override
    public void setScreenParent(ScreensController screenPage) {
        myController = screenPage;
    }
    
}
