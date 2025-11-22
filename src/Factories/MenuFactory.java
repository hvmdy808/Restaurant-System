package Factories;

import Items.AbstractItems.Burger;
import Items.AbstractItems.Drink;
import Items.AbstractItems.Pizza;

public interface MenuFactory {
   public Pizza createPizza();
   public Burger createBurger();
   public Drink createDrink();
}
