package Discount;

import Items.AbstractItems.MenuItem;

public class NoDiscount implements DiscountStrategy{
  ;

    @Override
 public double discount(MenuItem item){
    return item.getPrice();
    }
}
