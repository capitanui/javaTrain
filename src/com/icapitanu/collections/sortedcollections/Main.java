package com.icapitanu.collections.sortedcollections;
/*
* @author ionutcapitanu on 2020-06-19 
*/
public class Main {

    public static StockList stockList = new StockList();

    public static void main(String[] args) {
        StockItem temp = new StockItem( "bread", 0.86, 100 );
        stockList.addStock( temp );

        temp = new StockItem( "cake", 1.10, 7 );
        stockList.addStock( temp );

        temp = new StockItem( "car", 12.5, 2 );
        stockList.addStock( temp );

        temp = new StockItem( "chair", 62.0, 10 );
        stockList.addStock( temp );

        temp = new StockItem( "cup", 0.5, 200 );
        stockList.addStock( temp );

        temp = new StockItem("cup", 0.45, 7);
        stockList.addStock( temp);

        temp = new StockItem( "door", 72.95, 4 );
        stockList.addStock( temp );

        temp = new StockItem( "juice", 2.5, 36 );
        stockList.addStock( temp );

        temp = new StockItem( "phone", 96.99, 35 );
        stockList.addStock( temp );

        temp = new StockItem( "towel", 2.40, 80 );
        stockList.addStock( temp );

        temp = new StockItem( "vase", 8.76, 40 );

        System.out.println( stockList);

        Basket timsBasket = new Basket("Tim");

         addItem(timsBasket,"car",1);
        System.out.println(timsBasket);

        addItem(timsBasket,"car",1);
        System.out.println(timsBasket);

        addItem(timsBasket,"car",1);
        addItem(timsBasket,"spanner",5);
        System.out.println(timsBasket);

        addItem(timsBasket,"juice",4);
        addItem(timsBasket,"cup",12);
        addItem(timsBasket,"bread",1);
        System.out.println(timsBasket);

        removeItem(timsBasket,"cup",1);
        System.out.println(timsBasket);
        removeItem(timsBasket,"cup",1);
        System.out.println(timsBasket);
        removeItem(timsBasket,"juice",1);
        System.out.println(timsBasket);
        removeItem(timsBasket,"juice",4);
        System.out.println(timsBasket);
        removeItem(timsBasket,"car",1);
        System.out.println(timsBasket);

        addItem(timsBasket,"cup",3);
        System.out.println(timsBasket);

        addItem(timsBasket,"cake",6);
        System.out.println(timsBasket);

        addItem(timsBasket,"cake",2);
        System.out.println(timsBasket);

        timsBasket.checkout();


    }

      public static int addItem(Basket basket, String item, int quantity) {
        //retrieve the item from the stock list
          StockItem stockItem = stockList.get(item);
          if (stockItem == null) {
              System.out.println("We don't sell " + item);
              return  0;
          }

          if (stockList.adjustReservedStock(item, quantity) !=  0) {
              basket.addItem(stockItem,quantity);
              return quantity;
          }

        return 0;
      }

    public static int removeItem(Basket basket, String item, int quantity) {
        //retrieve the item from the stock list
        StockItem stockItem = stockList.get(item);
        if (stockItem == null) {
            System.out.println(item + " Doesn't exist in the basket");
            return  0;
        }

        if (stockList.adjustReservedStock(item, -quantity) !=  0) {
            basket.removeItem(stockItem,quantity);
            return quantity;
        }

        return 0;
    }
}
