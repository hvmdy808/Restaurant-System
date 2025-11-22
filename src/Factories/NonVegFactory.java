package Factories;

import Items.AbstractItems.Burger;
import Items.AbstractItems.Drink;
import Items.AbstractItems.Pizza;
import Items.Burgers.NonVegBurger;
import Items.Drinks.NonVegDrink;
import Items.Pizzas.NonVegPizza;

public class NonVegFactory implements MenuFactory{


    @Override
    public Pizza createPizza(){
 return new NonVegPizza();
    }

    @Override
    public Burger createBurger(){
        return new NonVegBurger();

    }


    @Override
    public Drink createDrink(){
        return new NonVegDrink();

    }
}
