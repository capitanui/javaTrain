package com.icapitanu.oopmaster;

// a) Healthy burger (on a brown rye bread roll), plus two addition items that can be added.
// The healthy burger can have 6 items (Additions) in total.
// hint:  you probably want to process the two additional items in this new class (subclass of Hamburger),
// not the base class (Hamburger), since the two additions are only appropriate for this new class
// (in other words new burger type).

public class HealthyHamburger extends Hamburger {
    private Addition extraSalad;
    private Addition seedsMix;

    public HealthyHamburger(double price, String meat) {
        super("Healthy Burger", price,"Brown rye bread roll", meat);
    }

    public void addExtraSalad(Addition extraSalad) {
        this.extraSalad = extraSalad;
        setFullPrice(getFullPrice() + extraSalad.getPrice());
    }

    public void addSeedsMix(Addition seedsMix) {
        this.seedsMix = seedsMix;
        setFullPrice(getFullPrice() + seedsMix.getPrice());
    }

    @Override
    public void listAdditions() {
        super.listAdditions();
        if (extraSalad != null) { System.out.println(extraSalad.toString()); }
        if (seedsMix != null) { System.out.println(seedsMix.toString()); }
     }
}
