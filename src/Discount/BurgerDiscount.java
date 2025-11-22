package Discount;

import Items.AbstractItems.MenuItem;

public class BurgerDiscount implements DiscountStrategy{
    @Override
    public double discount(double price) {
        return (price*(1-(20.0/100.0)));
    }
}
