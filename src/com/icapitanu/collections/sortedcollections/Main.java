package com.icapitanu.collections.sortedcollections;
/*
* @author ionutcapitanu on 2020-06-19 
*/
public class Main {

    public static StockList stockList = new StockList();

    public static void main(String[] args) {
        StockItem temp = new StockItem( "bread", 0.86, 100 );
        stockList.addStock( temp );

        temp = new StockItem( "cacke", 1.10, 7 );
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

         sellItem(timsBasket,"car",1);
        System.out.println(timsBasket);

        sellItem(timsBasket,"car",1);
        System.out.println(timsBasket);

        sellItem(timsBasket,"car",1);
        sellItem(timsBasket,"spanner",5);
        System.out.println(timsBasket);

        sellItem(timsBasket,"juice",4);
        sellItem(timsBasket,"cup",12);
        sellItem(timsBasket,"bread",1);


    }

      public static int sellItem(Basket basket, String item, int quantity) {
        //retrieve the item from the stock list
          StockItem stockItem = stockList.get(item);
          if (stockItem == null) {
              System.out.println("We don't sell " + item);
              return  0;
          }

          if (stockList.sellStock(item, quantity) !=  0) {
              basket.addToBasket(stockItem,quantity);
              return quantity;
          }

        return 0;
      }
}
