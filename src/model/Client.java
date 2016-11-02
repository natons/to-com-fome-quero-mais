package model;

import java.util.List;

public class Client extends User{
    private Integer cardNumber;

    public Client() {
    }

    public Client(Integer cardNumber, String login, String password, String name, Address address, List<Phone> phones) {
        super(login, password, name, address, phones);
        this.cardNumber = cardNumber;
    }

    public Integer getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Integer cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public String toString() {
        return "Client{" + "login=" + getLogin() + ", password=" + getPassword() + ", "
                + "name=" + getName() + ", address=" + getAddress() + ", "
                + "cardNumber=" + cardNumber + "phones=" + toStringPhones() + '}';
    }
    
    
}
