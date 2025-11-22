package Items.Drinks;

import Items.AbstractItems.Drink;

public class NonVegDrink extends Drink {

    @Override
    public  double getPrice(){
        return 70;
    }
    @Override
    public  String getName(){
        return "Drink";

    }
}
