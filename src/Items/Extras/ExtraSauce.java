package Items.Extras;

import Items.AbstractItems.AddOnsDecorator;
import Items.AbstractItems.MenuItem;

public class ExtraSauce extends AddOnsDecorator {
    private MenuItem item;

    @Override
    public  double getPrice(){
        return item.getPrice()+5;
    }
    @Override
    public  String getName(){
        return item.getName()+" Extra "+"Sauce";

    }

}
