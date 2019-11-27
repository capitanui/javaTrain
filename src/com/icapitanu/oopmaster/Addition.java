package com.icapitanu.oopmaster;

public  class Addition {
    private String name;
    private double price;
    private boolean isAdded;

    public Addition(String name, double price) {
        this.name = name;
        this.price = price;
        isAdded=true;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return  " " + name + " " + price;
    }
}
