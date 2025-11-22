package Items.Extras;

import Items.AbstractItems.AddOnsDecorator;
import Items.AbstractItems.MenuItem;

public class ExtraCheese extends AddOnsDecorator {
    private MenuItem item;

    @Override
    public  double getPrice(){
       return item.getPrice()+10;
    }
    @Override
    public  String getName(){
        return item.getName()+" Extra "+"Cheese";

    }
}
