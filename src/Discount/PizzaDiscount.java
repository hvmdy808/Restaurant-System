package Discount;

import Items.AbstractItems.MenuItem;

public class PizzaDiscount implements DiscountStrategy{

    @Override
  public  double discount(MenuItem item){
        return (item.getPrice()*(1-(30.0/100.0)));
    }
}
