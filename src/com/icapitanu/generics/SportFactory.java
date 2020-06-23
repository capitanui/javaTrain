package com.icapitanu.generics;
/*
* @author ionutcapitanu on 2020-01-15 
*/
public abstract class SportFactory {

    public static <T extends Sport> Sport getInstance(Class<T> type)
    {
        if (type.equals(Football.class)) return new Football();
        if (type.equals(TableTennis.class)) return new TableTennis();
        return null;
    }
}
