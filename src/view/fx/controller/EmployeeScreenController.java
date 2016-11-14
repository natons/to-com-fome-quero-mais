package view.fx.controller;

import controller.ControllerDessert;
import controller.ControllerDish;
import controller.ControllerDrink;
import controller.ControllerProduct;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.Client;
import model.Dessert;
import model.Dish;
import model.Drink;
import model.Employee;
import model.Order;
import model.Product;
import model.Request;

public class EmployeeScreenController implements Initializable{
    
    //tab1
    
    @FXML
    private ListView listDrink;
    
    @FXML
    private ListView listDrinkPrice;
    
    @FXML
    private ListView listDish;
    
    @FXML
    private ListView listDishPrice;
    
    @FXML
    private ListView listDessert;
    
    @FXML
    private ListView listDessertPrice;
    
    @FXML
    private ListView listOrder;
    
    @FXML
    private ListView listProductQuantity;
    
    @FXML
    private TextField tfNameClient;
    
    @FXML
    private TextField tfNicknameClient;
    
    @FXML
    private TextArea taObservation;
    
    private List<Product> products;
    private List<Client> clients;
    private Employee employee;

    //tab2
    @FXML
    private ListView listNameClient;
    
    @FXML
    private ListView listNicknameClient;
    
    @FXML
    private ListView listOrderCaixa;
    
    
    public EmployeeScreenController() {
        products = new ControllerProduct().getProducts();
        clients = new ArrayList<>();
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        init();
    }

    
    public void setEmployee(Employee employee){
        this.employee = employee;
    }

    private void init() {
        initListDrink();
        initListDish();
        initListDessert();
    }

    private void initListDrink() {
        List<Drink> drinks = new ControllerDrink().getAllElements();
        ObservableList<String> drinksItems = FXCollections.observableArrayList();
        ObservableList<String> drinksPrices = FXCollections.observableArrayList();
        
        drinks.forEach((drink) -> {
           drinksItems.add(drink.getProductDrink().getName());
           drinksPrices.add(drink.getProductDrink().getPrice().toString());
        });
        
        listDrink.setItems(drinksItems);
        listDrinkPrice.setItems(drinksPrices);
    }
    
    private void initListDish() {
        List<Dish> dishes = new ControllerDish().getAllElements();
        
        if(dishes.isEmpty())
            return;
        
        ObservableList<String> dishesItems = FXCollections.observableArrayList();
        ObservableList<String> dishesPrices = FXCollections.observableArrayList();
        
        dishes.forEach((dish) -> {
           dishesItems.add(dish.getProductDish().getName());
           dishesPrices.add(dish.getProductDish().getPrice().toString());
        });
        
        listDish.setItems(dishesItems);
        listDishPrice.setItems(dishesPrices);
    }
    
    private void initListDessert() {
        List<Dessert> desserts = new ControllerDessert().getAllElements();
        
        if(desserts.isEmpty())
            return;
        
        ObservableList<String> dessertsItems = FXCollections.observableArrayList();
        ObservableList<String> dessertsPrices = FXCollections.observableArrayList();
        
        desserts.forEach((dessert) -> {
           dessertsItems.add(dessert.getProductDessert().getName());
           dessertsPrices.add(dessert.getProductDessert().getPrice().toString());
        });
        
        listDessert.setItems(dessertsItems);
        listDessertPrice.setItems(dessertsPrices);
        
    }
    
    @FXML
    public void onMouseClickDrink(){
        defineSelectItem(listDrinkPrice,listDrink.getSelectionModel().getSelectedIndex());
        clearSelection(listDish, listDishPrice);
        clearSelection(listDessert, listDessertPrice);
    }
    
    @FXML
    public void onMouseClickDrinkPrice(){
        defineSelectItem(listDrink,listDrinkPrice.getSelectionModel().getSelectedIndex());
        clearSelection(listDish, listDishPrice);
        clearSelection(listDessert, listDessertPrice);
    }
    
    @FXML
    public void onMouseClickDish(){
        defineSelectItem(listDishPrice,listDish.getSelectionModel().getSelectedIndex());
        clearSelection(listDrink, listDrinkPrice);
        clearSelection(listDessert, listDessertPrice);
    }
    
    @FXML
    public void onMouseClickDishPrice(){
        defineSelectItem(listDish,listDishPrice.getSelectionModel().getSelectedIndex());
        clearSelection(listDrink, listDrinkPrice);
        clearSelection(listDessert, listDessertPrice);
    }
    
    @FXML
    public void onMouseClickDessert(){
        defineSelectItem(listDessertPrice,listDessert.getSelectionModel().getSelectedIndex());
        clearSelection(listDish, listDishPrice);
        clearSelection(listDrink, listDrinkPrice);
    }
    
    @FXML
    public void onMouseClickDessertPrice(){
        defineSelectItem(listDessert,listDessertPrice.getSelectionModel().getSelectedIndex());
        clearSelection(listDish, listDishPrice);
        clearSelection(listDrink, listDrinkPrice);
    }
    
    @FXML
    public void onMouseClickOrder(){
        defineSelectItem(listProductQuantity, listOrder.getSelectionModel().getSelectedIndex());
        clearSelection(listDish, listDishPrice);
        clearSelection(listDrink, listDrinkPrice);
        clearSelection(listDessert, listDessertPrice);
    }
    
    @FXML
    public void onMouseClickProductQuantity(){
        defineSelectItem(listOrder, listProductQuantity.getSelectionModel().getSelectedIndex());
        clearSelection(listDish, listDishPrice);
        clearSelection(listDrink, listDrinkPrice);
        clearSelection(listDessert, listDessertPrice);
    }
    
    private void defineSelectItem(ListView listView, int index){
        listView.getSelectionModel().select(index);
    }
    
    private void clearSelection(ListView listView, ListView listViewPrices){
        listView.getSelectionModel().clearSelection();
        listViewPrices.getSelectionModel().clearSelection();
    }
    
    @FXML
    private void onActionInsert(){
        addProductsAndQuantity(getSelectedProducts());
        
    }
    
    
    
    @FXML
    private void onActionRemove(){
        removeProductsAndQuantity();
    }

    private ObservableList<String> getSelectedProducts() {
    
        
        if(!listDessert.getSelectionModel().getSelectedItems().isEmpty()){
            return listDessert.getSelectionModel().getSelectedItems();
        } else if(!listDrink.getSelectionModel().getSelectedItems().isEmpty()){
            return listDrink.getSelectionModel().getSelectedItems();
        } else if(!listDish.getSelectionModel().getSelectedItems().isEmpty()){
            return listDish.getSelectionModel().getSelectedItems();
        }
           
        return FXCollections.observableArrayList();
    }
    
    private void addProductsAndQuantity(ObservableList<String> selectedProducts) {
        
        boolean flag = true;
        for(String selectedProduct : selectedProducts){
            flag = false;
            for(int i = 0; i < listOrder.getItems().size() && !flag; i++){
                if(selectedProduct.equals(listOrder.getItems().get(i))){
                    
                    int size = Integer.parseInt((String) listProductQuantity.getItems().get(i)) + 1;
                    
                    listProductQuantity.getItems().set(i,String.valueOf(size));
                    
                    flag = true;
                } 
            }
            
            if(!flag){
                listOrder.getItems().add(selectedProduct);
                listProductQuantity.getItems().add("1");
            }
        }
    }

    private void removeProductsAndQuantity() {
        
        List<Integer> list = listProductQuantity.getSelectionModel().getSelectedIndices();        
        for(Integer item : list){
            if(listProductQuantity.getItems().get(item).equals("1")){
                listProductQuantity.getItems().remove(listProductQuantity.getItems().get(item));
                listOrder.getItems().remove(listOrder.getItems().get(item));
            } else {
                int quantity = Integer.parseInt((String) listProductQuantity.getItems().get(item)) - 1;
                listProductQuantity.getItems().set(item, String.valueOf(quantity));
            }
        }
                
    }
    
    @FXML
    public void onActionConfirmOrder(){
        
        createOrderClient();
        
        for(Client client : clients){
            if(!itemWasChosen(listNameClient.getItems(), client.getName())){
                listNameClient.getItems().add(client.getName());
            }
            
            if(!itemWasChosen(listNicknameClient.getItems(), client.getNickname())){
                listNicknameClient.getItems().add(client.getNickname());
            }
        }
    }

    private void createOrderClient() {
        Client client = new Client();
        client.addEmployee(employee);
        client.setName(tfNameClient.getText());
        client.setNickname(tfNicknameClient.getText());
        
        Order order = new Order();
        order.setObservation(taObservation.getText());
        
        List<Dessert> desserts = new ArrayList<>();
        List<Drink> drinks = new ArrayList<>();
        List<Dish> dishes = new ArrayList<>();
        for(Product iterator : products){
            
            if(itemWasChosen(listOrder.getItems(),iterator.getName())){
                Dessert dessert = iterator.getDessert();
                if(dessert != null){
                    Request request = new Request();
                    request.setProduct(iterator);
                    int index = getIndexList(listProductQuantity.getItems(), iterator.getName());
                    request.setQuantity(Integer.parseInt((String) listProductQuantity.getItems().get(index)));
                    dessert.getProductDessert().addRequest(request);
                    dessert.setProductDessert(iterator);
                    desserts.add(dessert);
                }
                
                
                Drink drink = iterator.getDrink();
                if(drink != null){
                    Request request = new Request();
                    request.setProduct(iterator);
                    int index = getIndexList(listProductQuantity.getItems(), iterator.getName());
                    request.setQuantity(Integer.parseInt((String) listProductQuantity.getItems().get(index)));
                    drink.getProductDrink().addRequest(request);
                    drink.setProductDrink(iterator);
                    drinks.add(iterator.getDrink());
                }
                
                
                Dish dish = iterator.getDish();
                if(dish != null){
                    Request request = new Request();
                    request.setProduct(iterator);
                    int index = getIndexList(listProductQuantity.getItems(), iterator.getName());
                    request.setQuantity(Integer.parseInt((String) listProductQuantity.getItems().get(index)));
                    dish.getProductDish().addRequest(request);
                    dish.setProductDish(iterator);
                    dishes.add(iterator.getDish());
                }
                
            }
        }
        
        order.setDesserts(desserts);
        order.setDrinks(drinks);
        order.setDishes(dishes);
        
        order.setDateOrder(new Date());
        client.addOrder(order);
        clients.add(client);
    }
    
    private boolean itemWasChosen(ObservableList<String> list, String item){
        for(String it : list){
            if(it.equals(item))
                return true;
        }
        return false;
    }

    private int getIndexList(ObservableList items, String name) {
        for(int i = 0; i < items.size(); i++){
            if(items.get(i).equals(name))
                return i;
        }
        
        return 0;
    }
    
    @FXML
    public void onMouseClickNameClient(){
        listNicknameClient.getSelectionModel().select(listNameClient.getSelectionModel().getSelectedIndex());
        ObservableList<String> items = FXCollections.observableArrayList();
        
        List<Dessert> desserts = getClient((String) listNicknameClient.getSelectionModel().getSelectedItem())
                .getLastOrder().getDesserts();
        
        List<Dish> dishes = getClient((String) listNicknameClient.getSelectionModel().getSelectedItem())
                .getLastOrder().getDishes();
        
        List<Drink> drinks = getClient((String) listNicknameClient.getSelectionModel().getSelectedItem())
                .getLastOrder().getDrinks();
        
        if(desserts != null)
        for(Dessert dessert : desserts){
            items.add(dessert.getProductDessert().getName());
        }
        
        if(dishes != null)
        for(Dish dish : dishes){
           items.add(dish.getProductDish().getName());
        }
        
        if(drinks != null)
        for(Drink drink : drinks){
            items.add(drink.getProductDrink().getName());
        }
        listOrderCaixa.setItems(items);
    }
    
    private Client getClient(String nickname){
        for(Client client : clients){
            if(client.getNickname().equals(nickname)){
                return client;
            }
        }
        
        return new Client();
    }

    
}
