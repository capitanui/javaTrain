package com.icapitanu.abstractclasses;

public abstract class ListItem {
    public  ListItem next;
    public  ListItem previous;
    private String value;

    public ListItem(String value) {
        this.value = value;
    }

    public abstract ListItem goNext();

    public abstract ListItem goBack();

    public void setNext(ListItem next) {
        this.next = next;
    }

    public void setPrevious(ListItem previous) {
        this.previous = previous;
    }

    public boolean hasNext() {
        return (next != null);
    }

    public boolean hasPrevious() {
        return (previous != null);
    }

    public String getValue() {
        return value;
    }

    public int compareTo(ListItem itemForComparison) {
      return this.value.compareTo(itemForComparison.getValue());
    }
}
