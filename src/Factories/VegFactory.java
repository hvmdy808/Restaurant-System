package Factories;

import Items.AbstractItems.Burger;
import Items.AbstractItems.Drink;
import Items.AbstractItems.Pizza;
import Items.Burgers.VegBurger;
import Items.Drinks.VegDrink;
import Items.Pizzas.VegPizza;

public class VegFactory implements MenuFactory{

    @Override
    public Pizza createPizza(){

        return new VegPizza();

    }

    @Override
    public Burger createBurger(){
return new VegBurger();
    }


    @Override
    public Drink createDrink(){
return new VegDrink();
    }
}
