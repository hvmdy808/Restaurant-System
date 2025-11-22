package Discount;

import Items.AbstractItems.MenuItem;

public class NoDiscount implements DiscountStrategy{
    private double  Discount_price=0;
    @Override
    public void setDiscount(String price){
        Discount_price=0;
    }
    @Override
 public double discount(MenuItem item){
    return item.getPrice();
    }
}
