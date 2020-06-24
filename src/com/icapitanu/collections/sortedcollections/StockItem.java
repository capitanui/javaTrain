package com.icapitanu.collections.sortedcollections;
/*
* @author ionutcapitanu on 2020-06-18 
*/
public class StockItem implements Comparable<StockItem> {
    private final String name;
    private double price;
    private int quantityStock;
    private int reservedStock;

    public StockItem(String name, double price) {
        this.name = name;
        this.price = price;
        this.quantityStock = 0;
        this.reservedStock = 0;
    }

    public StockItem(String name, double price, int quantityStock) {
        this.name = name;
        this.price = price;
        this.quantityStock = quantityStock;
        this.reservedStock = 0;
    }

   public void setReservedStock(int reservedStock) {
        int newReservedStock = this.reservedStock + reservedStock;
        if ((newReservedStock >= 0) && (reservedStock <= quantityInStock())) {
            this.reservedStock = newReservedStock;
        }
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int quantityInStock() {
        return quantityStock-reservedStock;
    }


    public void  adjustStock(int quantity) {
         int newQuantity = this.quantityStock + quantity;
         if (newQuantity >= 0) {
             this.quantityStock = newQuantity;
         }
    }

    @Override
    public boolean equals(Object obj) {
        System.out.println("Entering StockItem.equals");
        if (obj == this) {
            return true;
        }

        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        String objname = ((StockItem) obj).getName();
        return this.name.equals(objname);
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + 33;
    }

    @Override
    public int compareTo(StockItem o) {
        if (this == o) {
            return 0;
        }

        if (o != null) {
            return this.name.compareTo(o.getName());
        }

        throw new NullPointerException();
    }

    @Override
    public String toString() {
        return this.name + " : " + this.price;
    }
}
