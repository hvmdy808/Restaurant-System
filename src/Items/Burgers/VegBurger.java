package Items.Burgers;

import Items.AbstractItems.Burger;

public class VegBurger extends Burger {
    @Override
    public double getPrice(){
        return 90;
    }

    @Override
    public String getName(){
        return "Vegetarian Burger";
    }
}
