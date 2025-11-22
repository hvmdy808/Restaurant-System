package Items.Drinks;

import Items.AbstractItems.Drink;

public class VegDrink extends Drink {
    @Override
    public  double getPrice(){
        return 60;
    }
    @Override
    public  String getName(){
        return "Vegetarian Drink";

    }
}
