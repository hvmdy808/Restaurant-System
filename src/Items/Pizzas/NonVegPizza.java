package Items.Pizzas;

import Items.AbstractItems.MenuItem;
import Items.AbstractItems.Pizza;

public class NonVegPizza extends Pizza {

    @Override
    public  double getPrice(){
        return 150;
    }
    @Override
    public  String getName(){
        return "Meat Pizza";

    }
}
