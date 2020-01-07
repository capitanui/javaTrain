package com.icapitanu.abstractclasses;

public class ShoppingList {
    private String name;
     private ShoppingListItem head;
    private ShoppingListItem tail;

    public ShoppingList(String name) {
        this.name = name;
     }

    public boolean addItem(ShoppingListItem item) {
        if (head == null) {
            head = item;
            tail = head;
        }  else if (findItem(item.getValue()) != null) return false;
                else {
                      ShoppingListItem itemToInsertBefore = findInsertPoint(item);

                      if (itemToInsertBefore==null) { // new tail
                          tail.setNext(item);
                          item.setPrevious(tail);
                          tail = item;
                      } else if (!itemToInsertBefore.hasPrevious()) { // new head
                          head.setPrevious(item);
                          item.setNext(head);
                          head = item;
                      } else {
                          itemToInsertBefore.goBack().setNext(item);
                          item.setPrevious(itemToInsertBefore.goBack());
                          item.setNext(itemToInsertBefore);
                          itemToInsertBefore.setPrevious(item);
                      }
                }
                return true;
    }

    public boolean removeItem(String itemName) {
        ShoppingListItem itemToRemove = findItem(itemName);
        if (itemToRemove != null){
                   if (itemToRemove.hasNext()) itemToRemove.goNext().setPrevious(itemToRemove.previous);
                        else tail = (ShoppingListItem) itemToRemove.goBack();
                   if (itemToRemove.hasPrevious())  itemToRemove.goBack().setNext(itemToRemove.next);
                        else head = (ShoppingListItem) itemToRemove.goNext();

                           System.out.println("itemToRemove value : " + itemToRemove.getValue());
                 itemToRemove.setNext(null);
                 itemToRemove.setPrevious(null);
                return true;
            }  else return false;
     }


    public ShoppingListItem findItem(String itemName){
        ShoppingListItem iterator = head;
        while (iterator.hasNext()) {
            if  (iterator.getValue().equals(itemName)) return iterator;
                else iterator = (ShoppingListItem) iterator.goNext();
        }
        if (tail.getValue().equals(itemName)) return tail;
            else  return null;
    }

    public ShoppingListItem findInsertPoint(ShoppingListItem item){
        ShoppingListItem iterator = head;
        while (iterator.hasNext()) {
            if (item.compareTo(iterator)<0) return  iterator;
            iterator = (ShoppingListItem) iterator.goNext();
        }
        if (item.compareTo(tail)<=0) return tail;
            else return null;
    }

    @Override
    public String toString(){
        String listOutput="";
        if (head != null) {
            ShoppingListItem iterator = head;
            while (iterator.hasNext()) {
                listOutput += "Item name : " + iterator.getValue() + " \t Price : " + iterator.getPrice() + "$\n";
                iterator = (ShoppingListItem) iterator.goNext();
            }
            listOutput += "Item name : " + tail.getValue() + " \t Price : " + tail.getPrice() + "$";
        }
        return listOutput;
    }
}
