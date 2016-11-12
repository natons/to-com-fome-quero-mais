package view.fx.controller;
import controller.ControllerEmployee;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import validator.Validator;
import view.fx.NewFXMain;

/*
    Classe de interface gŕafica referente ao Login
*/

public class LoginScreenController implements Initializable, ControlledScreen{
    
    ScreensController myController;
    
    @FXML
    private Label lbMessageLogin;
    
    @FXML
    private Label lbMessagePassword;
    
    @FXML
    private Label lbMessage;
    
    @FXML
    private PasswordField pfPassword;
    
    @FXML
    private TextField tfLogin;
    
    private Stage stage;
    
    public LoginScreenController() {
    }

    /*
        Executa uma ação referente ao botão Login.
        Setando mensagens nas labels caso ocorra algo errado, caso contrário,
        direciona para outra janela.
    */
    @FXML
    public void actionButton(ActionEvent event) {
        boolean flagLogin = Validator.validatorString(tfLogin.getText());
        boolean flagPassword = Validator.validatorString(pfPassword.getText());
        
        setMessage(flagLogin, lbMessageLogin, "Campo Obrigatório!");
        setMessage(flagPassword, lbMessagePassword, "Campo Obrigatório!");
        
        verifyData(flagLogin, flagPassword);
    }
    
    
    private void setMessage(boolean flag, Label label, String message){
        if(flag){
            label.setVisible(false);
        } else {
            label.setText(message);
            label.setVisible(true);
            pfPassword.setText("");
        }
    }

    private void verifyData(boolean flagLogin, boolean flagPassword) {
        if(!flagLogin || !flagPassword)
            return;
            
        if(new ControllerEmployee().authenticate(tfLogin.getText(), pfPassword.getText())){
            myController.setScreen(NewFXMain.employeeId);
        } else {
            lbMessage.setText("login ou senha incorretos");
            lbMessage.setVisible(true);
        }
        
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @Override
    public void setScreenParent(ScreensController screenPage) {
        myController = screenPage;
    }

}
