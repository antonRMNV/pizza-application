package com.example.app.model;

public class Pizza {
    private String pizzasName;
    private int pizzasSize;
    private int pizzasPrice;

    public String getPizzasName() {
        return pizzasName;
    }

    public void setPizzasName(String pizzasName) {
        this.pizzasName = pizzasName;
    }

    public int getPizzasSize() {
        return pizzasSize;
    }

    public void setPizzasSize(int pizzasSize) {
        this.pizzasSize = pizzasSize;
    }

    public int getPizzasPrice() {
        return pizzasPrice;
    }

    public void setPizzasPrice(int pizzasPrice) {
        this.pizzasPrice = pizzasPrice;
    }

    public Pizza(String pizzasName, int pizzasSize, int pizzasPrice) {
        this.pizzasName = pizzasName;
        this.pizzasSize = pizzasSize;
        this.pizzasPrice = pizzasPrice;
    }

    @Override
    public String toString() {
        return pizzasName + "\t\t\t\t\t\t\t     "
                + pizzasSize + " см"  + "\t     " + pizzasPrice + " ₴";
    }
}
