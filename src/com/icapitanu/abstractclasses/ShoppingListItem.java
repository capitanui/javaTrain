package com.icapitanu.abstractclasses;

/*
* @author ionutcapitanu on 2019-12-16 
*/
public class ShoppingListItem extends com.icapitanu.ListItem {

    private double price;

    public ShoppingListItem(String name, double price) {
        super(name);
        this.price = price;
    }

    @Override
    public com.icapitanu.ListItem goNext() {
        if (hasNext()) {
            return next;
        }
        return null;
    }

    @Override
    public com.icapitanu.ListItem goBack() {
        if (hasPrevious()){
            return previous;
        }
        return null;
     }

    public double getPrice() {
        return price;
    }

    static ShoppingListItem createShoppingItem (String name, double price){
        return new ShoppingListItem(name,price);
    }
}
