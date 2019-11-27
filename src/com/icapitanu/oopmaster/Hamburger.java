package com.icapitanu.oopmaster;

public  class Hamburger {
    private String name;
    private double price;
    private double fullPrice;
    private String breadRollType;
    private String meat;
    private Addition lettuceAddition;
    private Addition tomatoAddition;
    private Addition onionAddition;
    private Addition carrotAddition;

    public Hamburger(String name, double price, String breadRollType, String meat) {
        this.name = name;
        this.price = price;
        this.fullPrice = price;
        this.breadRollType = breadRollType;
        this.meat = meat;
    }

    public void addLettuce(Addition lettuceAddition) {
        this.lettuceAddition = lettuceAddition;
        fullPrice+=lettuceAddition.getPrice();
    }

    public void addTomato(Addition tomatoAddition) {
        this.tomatoAddition = tomatoAddition;
        fullPrice+=tomatoAddition.getPrice();
    }
    public void addOnion(Addition onionAddition) {
        this.onionAddition = onionAddition;
        fullPrice+=onionAddition.getPrice();
    }

    public void addCarrot(Addition carrotAddition) {
        this.carrotAddition = carrotAddition;
        fullPrice+=carrotAddition.getPrice();
    }

    public void setFullPrice(double fullPrice) {
        this.fullPrice = fullPrice;
    }

    public double getFullPrice() {
        return fullPrice;
    }

    public void listAdditions() {
        if (lettuceAddition != null) { System.out.println(lettuceAddition.toString()); }
        if (tomatoAddition != null) { System.out.println(tomatoAddition.toString()); }
        if (onionAddition != null) { System.out.println(onionAddition.toString()); }
        if (carrotAddition != null) { System.out.println(carrotAddition.toString()); }
    }

    public void listBurger() {
        System.out.println(name + " " + price);
        listAdditions();
        System.out.println("Total price for hamburger : " + fullPrice);
    }
 }

