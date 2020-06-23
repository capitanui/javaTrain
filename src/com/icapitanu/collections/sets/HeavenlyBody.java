package com.icapitanu.collections.sets;

import java.util.HashSet;
import java.util.Set;

public abstract class HeavenlyBody {
     private final String name;
     private final double orbitalPeriod;
     private final Set<HeavenlyBody> satellites;
     private bodyType type;

     enum  bodyType
                { PLANET,
                    STAR,
                    MOON
                };

    public HeavenlyBody(String name, double orbitalPeriod) {
        this.name = name;
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
        this.type = null;
    }

    public String getName() {
        return name;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public boolean addSattelite (HeavenlyBody moon){
        return this.satellites.add(moon);
    }

    public Set<HeavenlyBody> getSatellites() {
        return new HashSet<>(this.satellites);
    }

    @Override
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if ((obj == null) || (obj.getClass() != this.getClass())) {
            return false;
        }

        // add type check
        bodyType type = ((HeavenlyBody) obj).getType();
        String objName = ((HeavenlyBody) obj).getName();

        return this.name.equals(objName) && this.type.equals(type);
    }

    @Override
    public final int hashCode() {
        return this.name.hashCode() + 57 + this.getType().hashCode();
    }

    public bodyType getType() {
        return type;
    }


    public void setType(bodyType type) {
        this.type = type;
    }

    public static final class Key {
        private String name;
        private bodyType bodyType;

        public Key(String name, bodyType bodyType) {
            this.name = name;
            this.bodyType = bodyType;
        }

        public String getName() {
            return name;
        }

        public HeavenlyBody.bodyType getBodyType() {
            return bodyType;
        }

        @Override
        public int hashCode() {
            return this.name.hashCode() + 57 + this.bodyType.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
           Key key = (Key) obj;
           if (this.name.equals(key.getName())) {
                return (this.bodyType == key.getBodyType());
            }return false;
        }

    }
}
