package view.fx.controller;

import controller.ControllerProduct;
import controller.ControllerStock;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Product;
import model.Stock;
import view.fx.LoginScreen;

public class AdminScreenController implements Initializable{
    
    private Stage stage;
    
    @FXML
    private TextField tfNameProduct;
    
    @FXML
    private TextField tfPriceProduct;
    
    @FXML
    private TextField tfMinimumAmount;
    
    @FXML
    private TextField tfAmount;
    
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
        saveProduct();
        clearTextFields();
        initListProducts();
        initListProductsAlert();
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
    }

    private void saveProduct() {
        new ControllerProduct().save(
                tfNameProduct.getText(),tfPriceProduct.getText(),tfAmount.getText(),tfMinimumAmount.getText());
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
