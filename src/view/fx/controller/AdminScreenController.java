package view.fx.controller;

import controller.ControllerDessert;
import controller.ControllerDish;
import controller.ControllerDrink;
import controller.ControllerProduct;
import controller.ControllerStock;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Product;
import model.Stock;
import validator.Validator;
import view.fx.LoginScreen;

public class AdminScreenController implements Initializable{
    
    private Stage stage;
    
    @FXML
    private Label lbMessage;
    
    @FXML
    private TextField tfNameProduct;
    
    @FXML
    private TextField tfPriceProduct;
    
    @FXML
    private TextField tfMinimumAmount;
    
    @FXML
    private TextField tfAmount;
    
    @FXML
    private ComboBox cbCategory;
    
    @FXML
    private ListView listProductsAlert;
    
    @FXML
    private ListView listProducts;
    
    @FXML
    private TextField tfSelectedMinimumAmount;
    
    @FXML
    private TextField tfSelectedAmount;
    
    private List<Product> products;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        init();
        products = new ControllerProduct().getProducts();
    }
    
    private Stage getStage(){
        return stage;
    }
    
    public void setStage(Stage stage){
        this.stage = stage;
    }
    
    @FXML
    public void onActionSaveProduct(){
        if(validateCamps()){
            saveProduct();
            clearTextFields();
            initListProducts();
            initListProductsAlert();
        } else {
            lbMessage.setVisible(true);
            lbMessage.setText("Todos os campos devem estar preenchidos!");
        }
    }
    
    public boolean validateCamps(){
        if(!Validator.validatorString(tfNameProduct.getText()) ||
                !Validator.validatorString(tfMinimumAmount.getText()) ||
                !Validator.validatorString(tfAmount.getText()) ||
                !Validator.validatorString(tfPriceProduct.getText()) ||
                cbCategory.getItems().isEmpty())
            return false;
        
        return true;
    }
    
    @FXML
    public void onActionSaveStock(){
        Product product = getProduct((String) listProducts.getSelectionModel().getSelectedItem());
        
        Stock stock = new Stock();
        stock.setAmount(Integer.parseInt(tfSelectedAmount.getText()));
        stock.setMinimumAmount(Integer.parseInt(tfSelectedMinimumAmount.getText()));
        stock.setProduct(product);
        stock.setIdStock(product.getStock().getIdStock());
        new ControllerStock().save(stock);
        
        initListProducts();
        initListProductsAlert();
    }

    private void clearTextFields() {
        tfNameProduct.clear();
        tfPriceProduct.clear();
        tfAmount.clear();
        tfMinimumAmount.clear();
        lbMessage.setText("");
        lbMessage.setVisible(false);
        
    }

    private void saveProduct() {
        
        switch((String)cbCategory.getSelectionModel().getSelectedItem()){
            case "Prato":
                new ControllerDish().save(
                tfNameProduct.getText(),tfPriceProduct.getText(),tfAmount.getText(),tfMinimumAmount.getText());
                break;
            case "Bebida":
                new ControllerDrink().save(
                tfNameProduct.getText(),tfPriceProduct.getText(),tfAmount.getText(),tfMinimumAmount.getText());
                break;
            case "Sobremesa":
                new ControllerDessert().save(
                tfNameProduct.getText(),tfPriceProduct.getText(),tfAmount.getText(),tfMinimumAmount.getText());
                break;
        }
    }

    private void init() {
        initListProducts();
        initListProductsAlert();
    }

    private void initListProducts() {
        products = new ControllerProduct().getProducts();
        ObservableList<String> data = FXCollections.observableArrayList();
        for(Product product : products){
            data.add(product.getName());
        }
        
        listProducts.setItems(data);
    }
    
    private void initListProductsAlert() {
        products = new ControllerProduct().getProducts();
        ObservableList<String> data = FXCollections.observableArrayList();
        for(Product product : products){
            if(product.getStock().getAmount() < product.getStock().getMinimumAmount())
                data.add(product.getName());
        }
        
        listProductsAlert.setItems(data);
    }
    
    @FXML
    public void onMouseClickProducts(){
        Integer amount = getProduct((String) listProducts.getSelectionModel().getSelectedItem()).getStock().getAmount();
        Integer minimumAmount = getProduct((String) listProducts.getSelectionModel().getSelectedItem()).getStock().getMinimumAmount();
        
        tfSelectedAmount.setText(amount.toString());
        tfSelectedMinimumAmount.setText(minimumAmount.toString());
    }
    
    @FXML
    public void onMouseClickProductsAlert(){
        listProducts.getSelectionModel().select(listProductsAlert.getSelectionModel().getSelectedItem());
        onMouseClickProducts();
    }
    
    private Product getProduct(String name){
        for(Product product : products){
            if(name.equals(product.getName()))
                return product;
        }
        return new Product();
    }
    
    @FXML
    public void logOut() throws Exception{
        new LoginScreen().start(getStage());
    }

    
    
}
