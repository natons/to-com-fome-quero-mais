package model;

import java.util.List;

public class User {
    
    private String login;
    private String password;
    private String name;
    private Address address;
    private List<Phone> phones;

    public User() {
    }

    public User(String login, String password, String name, Address address, List<Phone> phones) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.address = address;
        this.phones = phones;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    @Override
    public String toString() {
        return "User{" + "login=" + login + ", password=" + password + ", "
                + "name=" + name + ", address=" + address + ", phones=" + toStringPhones() + '}';
    }
    
    String toStringPhones(){
        String toString = null;
        for(Phone phone : phones){
            toString += phone.toString() + "\t";
        }
        return toString;
    }
    
    
    
    
    
}
