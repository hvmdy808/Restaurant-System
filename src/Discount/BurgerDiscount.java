package Discount;

import Items.AbstractItems.MenuItem;

public class BurgerDiscount implements DiscountStrategy{


    @Override
    public double discount(MenuItem item){
        return (item.getPrice()*(1-(20.0/100.0)));
    }
}
