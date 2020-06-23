package com.icapitanu.collections.sets;
/*
* @author ionutcapitanu on 2020-06-16 
*/
public class Star extends Planet{

    Star(String name, double orbitalPeriod) {
        super( name, orbitalPeriod );
        setType(bodyType.STAR);
    }
}
