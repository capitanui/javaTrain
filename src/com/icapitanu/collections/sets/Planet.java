package com.icapitanu.collections.sets;
/*
* @author ionutcapitanu on 2020-06-16 
*/
public class Planet extends HeavenlyBody {

    Planet(String name, double orbitalPeriod) {
        super( name, orbitalPeriod );
        setType(bodyType.PLANET);
    }

    @Override
    public boolean addSattelite(HeavenlyBody moon) {
            if (moon.getType() == bodyType.MOON) {
                return super.addSattelite(moon);
            } else
                return false;

     }
}
