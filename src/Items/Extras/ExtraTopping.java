package Items.Extras;

import Items.AbstractItems.AddOnsDecorator;
import Items.AbstractItems.MenuItem;

public class ExtraTopping extends AddOnsDecorator {
    String topping="Onion and ketchup";
    public ExtraTopping(MenuItem item) {
        super(item);
    }

    @Override
    public  double getPrice(){
        return item.getPrice()+10;
    }

    @Override
    public  String getName(){
        return item.getName()+" Extra "+topping;
    }
}
