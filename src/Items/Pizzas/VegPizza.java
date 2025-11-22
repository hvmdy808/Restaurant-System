package Items.Pizzas;

import Items.AbstractItems.Pizza;

public class VegPizza extends Pizza {


    @Override
    public  double getPrice(){
        return 110;
    }
    @Override
    public  String getName(){
        return "Vegetarian Pizza";

    }
}
