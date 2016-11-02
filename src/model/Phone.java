package model;

class Phone {
    private Integer DDD;
    private Integer number;

    public Phone(Integer DDD, Integer number) {
        this.DDD = DDD;
        this.number = number;
    }

    public Integer getDDD() {
        return DDD;
    }

    public void setDDD(Integer DDD) {
        this.DDD = DDD;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Phone{" + "DDD=" + DDD + ", number=" + number + '}';
    }
    
    
    
    
}
