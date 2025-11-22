package Items.Drinks;

import Items.AbstractItems.Drink;

public class KidsDrink extends Drink {


    @Override
    public  double getPrice(){
        return 50;
    }
    @Override
    public  String getName(){
        return "Kids Drink";

    }
}
