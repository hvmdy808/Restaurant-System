package Items.Burgers;

import Items.AbstractItems.Burger;

public class NonVegBurger extends Burger {
    @Override
    public double getPrice(){
        return 100;
    }

    @Override
    public String getName(){
        return "Buff Burger";
    }
}
