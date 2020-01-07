package com.icapitanu.abstractclasses;
/*
* @author ionutcapitanu on 2019-12-12 
*/
public abstract class ListItem {
    public com.icapitanu.ListItem next;
    public com.icapitanu.ListItem previous;
    private String value;

    public ListItem(String value) {
        this.value = value;
    }

    public abstract com.icapitanu.ListItem goNext();

    public abstract com.icapitanu.ListItem goBack();

    public void setNext(com.icapitanu.ListItem next) {
        this.next = next;
    }

    public void setPrevious(com.icapitanu.ListItem previous) {
        this.previous = previous;
    }

    public boolean hasNext() {
        if (next != null) return true;
        return false;
    }

    public boolean hasPrevious() {
        if (previous != null) return true;
        return false;
    }


    public String getValue() {
        return value;
    }

    public int compareTo(com.icapitanu.ListItem itemForComparison) {
      return this.value.compareTo(itemForComparison.getValue());
    }
}
