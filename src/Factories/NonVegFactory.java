package Factories;

import Items.AbstractItems.Burger;
import Items.AbstractItems.Drink;
import Items.AbstractItems.Pizza;

public class NonVegFactory implements MenuFactory{


    @Override
    public Pizza createPizza(){

    }

    @Override
    public Burger createBurger(){

    }


    @Override
    public Drink createDrink(){

    }
}
