package Discount;

import Items.AbstractItems.MenuItem;

public interface DiscountStrategy {
   public double discount(MenuItem item);

}
