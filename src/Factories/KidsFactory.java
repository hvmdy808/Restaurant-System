package Factories;

import Items.AbstractItems.Burger;
import Items.AbstractItems.Drink;
import Items.AbstractItems.Pizza;
import Items.Burgers.KidsBurger;
import Items.Drinks.KidsDrink;
import Items.Pizzas.KidsPizza;

public class KidsFactory implements MenuFactory{
@Override
    public Pizza createPizza(){
        return new KidsPizza();
    }

    @Override
    public Burger createBurger(){
        return new KidsBurger();
    }


    @Override
    public Drink createDrink(){
        return new KidsDrink();
    }

}
