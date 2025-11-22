package Items.Burgers;

import Items.AbstractItems.Burger;

public class KidsBurger extends Burger {    @Override
public  double getPrice(){
    return 80;
}
    @Override
    public  String getName(){
        return "Kids Burger";

    }
}
