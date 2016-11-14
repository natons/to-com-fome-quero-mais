package controller;

import model.Stock;
import model.dao.StockDAO;

public class ControllerStock {
    public void save(Stock stock){
        new StockDAO().save(stock);
    }
}
