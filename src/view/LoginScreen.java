package view;

import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import model.Client;
import validator.Validator;

/*
    Classe de interface gŕafica referente ao Login
*/

public class LoginScreen extends Application{

    private AnchorPane pane;
    private Scene scene;
    private Label lbLogin;
    private Label lbPassword;
    private Label lbMessageLogin;
    private Label lbMessagePassword;
    private TextField tfLogin;
    private PasswordField pfPassword;
    
    private Button btnLogin;
    private Button btnLogout;
    
    private Stage stage;

    public LoginScreen() {
        initComponents();
        initPositionComponents();
        saveClient();
    }

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        pane.getChildren().addAll(lbLogin, lbPassword, lbMessageLogin, lbMessagePassword,
                tfLogin, pfPassword, btnLogin, btnLogout);
        
        stage.setScene(scene);
        stage.setTitle("Tela de Login");
        stage.show();
    }
    
    //seta os valores dos campos
    private void initComponents() {
        pane = new AnchorPane();
        pane.getStyleClass().add("background");
        
        scene = new Scene(pane, 450, 250);
        scene.getStylesheets().add("style.css");
        
        lbLogin = new Label("Login: ");
        
        lbPassword = new Label("Senha: ");
        
        lbMessageLogin = new Label("");
        lbMessageLogin.setVisible(false);
        lbMessageLogin.getStyleClass().add("label-message");
        
        lbMessagePassword = new Label("");
        lbMessagePassword.setVisible(false);
        
        tfLogin = new TextField();
        tfLogin.setPromptText("Digite o seu login.");
        
        pfPassword = new PasswordField();
        pfPassword.setPromptText("Digite sua senha.");
        
        btnLogin = new Button("Entrar");
        btnLogin.getStyleClass().add("btn");
        btnLogin.setOnAction((event) -> {
            btnLoginAction();
        });
        
        btnLogout = new Button("Sair");
        btnLogout.getStyleClass().add("btn");
        btnLogout.setOnAction((event) -> {
            System.exit(0);
        });
    }

    //seta a posição dos componenentes, para compor o layout
    private void initPositionComponents() {
        lbLogin.setLayoutX(35);
        lbLogin.setLayoutY(94);
           
        lbPassword.setLayoutX(35);
        lbPassword.setLayoutY(144);
        
        lbMessageLogin.setLayoutX(280);
        lbMessageLogin.setLayoutY(94);
        
        lbMessagePassword.setLayoutX(280);
        lbMessagePassword.setLayoutY(144);
        
        tfLogin.setLayoutX(pane.getWidth()/2 - 130);
        tfLogin.setLayoutY(90);
        
        pfPassword.setLayoutX(pane.getWidth()/2 - 130);
        pfPassword.setLayoutY(140);
       
        btnLogin.setLayoutX(100);
        btnLogin.setLayoutY(180);
        
        btnLogout.setLayoutX(200);
        btnLogout.setLayoutY(180);
    }

    /*
        Executa uma ação referente ao botão Login.
        Setando mensagens nas labels caso ocorra algo errado, caso contrário,
        direciona para outra janela.
    */
    private void btnLoginAction() {
        
        boolean flagLogin = Validator.validatorString(tfLogin.getText());
        boolean flagPassword = Validator.validatorString(pfPassword.getText());
        
        setMessage(flagLogin, lbMessageLogin, "Campo Obrigatório!");
        setMessage(flagPassword, lbMessagePassword, "Campo Obrigatório!");
        
        if(flagLogin && flagPassword)
            JOptionPane.showMessageDialog(null, "Usuário inválido!");
    }
    
    
    private void setMessage(boolean flag, Label label, String message){
        if(flag){
            label.setVisible(false);
            pfPassword.setText("");
        } else {
            label.setText(message);
            label.setVisible(true);
        }
    }

    private void saveClient() {
        Client client = new Client();
        client.setLogin("teste");
        client.setName("joao");
        client.setPassword("123");
        
        
    }
    
    
    
}
