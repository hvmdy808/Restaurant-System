package Discount;

import Items.AbstractItems.MenuItem;

public class BurgerDiscount implements DiscountStrategy{
private double Discount_price=0;

    @Override
    public void setDiscount(String price){
        int index = price.indexOf('%');



        String numberPart = price.substring(0, index).trim();


        Discount_price = Double.parseDouble(numberPart);


    }

    @Override
    public double discount(MenuItem item){
        return (item.getPrice()*(1-Discount_price/100));
    }
}
