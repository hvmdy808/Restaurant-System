package Discount;

import Items.AbstractItems.MenuItem;

public class PizzaDiscount implements DiscountStrategy{

    @Override
  public  double discount(double price) {
        return (price*(1-(30.0/100.0)));
    }
}
