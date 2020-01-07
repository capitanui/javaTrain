package com.icapitanu.abstractclasses;

public class ShoppingListItem extends ListItem {

    private double price;

    public ShoppingListItem(String name, double price) {
        super(name);
        this.price = price;
    }

    @Override
    public ListItem goNext() {
            return next;
    }

    @Override
    public ListItem goBack() {
            return previous;
     }

    public double getPrice() {
        return price;
    }

    static ShoppingListItem createShoppingItem (String name, double price){
        return new ShoppingListItem(name,price);
    }
}
