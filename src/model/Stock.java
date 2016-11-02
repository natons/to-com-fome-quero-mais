package model;

public class Stock {
    private Integer amount;
    private Integer minAmount;

    public Stock() {
    }

    public Stock(Integer amount, Integer minAmount) {
        this.amount = amount;
        this.minAmount = minAmount;
    }

    @Override
    public String toString() {
        return "Stock{" + "amount=" + amount + ", minAmount=" + minAmount + '}';
    }
    
    
}
