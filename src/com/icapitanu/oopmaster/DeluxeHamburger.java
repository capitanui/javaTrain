package com.icapitanu.oopmaster;

 public class DeluxeHamburger extends Hamburger {
        private Addition chips;
        private Addition drink;

     public DeluxeHamburger(String name, double price, String breadRollType, String meat, Addition chips, Addition drink) {
         super(name, price, breadRollType, meat);
         this.chips = chips;
         setFullPrice(getFullPrice() + chips.getPrice());
         this.drink = drink;
         setFullPrice(getFullPrice() + drink.getPrice());
     }

     @Override
     public void listAdditions() {
         super.listAdditions();
         System.out.println(chips.toString());
         System.out.println(drink.toString());
     }
 }
