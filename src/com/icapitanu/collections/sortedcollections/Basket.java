package com.icapitanu.collections.sortedcollections;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/*
* @author ionutcapitanu on 2020-06-19 
*/
public class Basket {

    private final String name;
    private final Map<StockItem,Integer> list;

    public Basket(String name) {
        this.name = name;
        this.list = new TreeMap<>();
    }

    public int addItem(StockItem item, int quantity){
        if ((item != null ) && (quantity > 0)){
            int inBasket = list.getOrDefault(item,0);
            list.put(item, inBasket + quantity);
            return inBasket;
        }
        return 0;
    }

    public int removeItem(StockItem item, int quantity){
        if ((item != null ) && (quantity > 0)){
            int inBasket = list.getOrDefault(item,0);
            if ((inBasket - quantity) <= 0) {
                //remove item from the basket
                list.remove(item);
                //decrease reserved stock to 0
                item.setReservedStock(-inBasket);
             }
                else list.put(item, inBasket - quantity);
            return inBasket;
        }
        return 0;
    }

    public void checkout(){
        for (Map.Entry<StockItem,Integer> e : list.entrySet()){
             //adjust the stock
             e.getKey().adjustStock(-e.getValue());
             //remove reserved items
             e.getKey().setReservedStock(-e.getValue());
        }
        //clear the basket
        list.clear();
    }

    public Map<StockItem, Integer> Items(){
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
       String s = "\nShopping basket " + name + " contains " + list.size() + (list.size() == 1 ? " item" : " items") + "\n";
       double totalCost = 0.0;

       for (Map.Entry<StockItem, Integer> item : list.entrySet()) {
           s = s + item.getKey() + ". " + item.getValue() + " purchased\n";
           totalCost += item.getKey().getPrice() * item.getValue();
       }

       return s + "Total cost " + totalCost;
    }
}
