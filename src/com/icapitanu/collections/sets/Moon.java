package com.icapitanu.collections.sets;
/*
* @author ionutcapitanu on 2020-06-16 
*/
public class Moon extends HeavenlyBody {

    Moon(String name, double orbitalPeriod) {
        super( name, orbitalPeriod );
        setType(bodyType.MOON);    }
}