package Items.Pizzas;

import Items.AbstractItems.MenuItem;
import Items.AbstractItems.Pizza;

public class KidsPizza extends Pizza {

    @Override
    public  double getPrice(){
        return 100;
    }
    @Override
    public  String getName(){
        return "Kids Pizza";

    }
}
