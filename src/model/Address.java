package model;

class Address {
    
    private String street;
    private Integer number;
    private String city;
    private String neighborhood;

    public Address(String street, Integer number, String city, String neighborhood) {
        this.street = street;
        this.number = number;
        this.city = city;
        this.neighborhood = neighborhood;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    @Override
    public String toString() {
        return "Address{" + "street=" + street + ", number=" + number + ", city=" + city + ", neighborhood=" + neighborhood + '}';
    }
    
    
    
}
