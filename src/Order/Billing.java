package Order;

import Discount.BurgerDiscount;
import Discount.DiscountStrategy;
import Discount.NoDiscount;
import Discount.PizzaDiscount;
import Items.AbstractItems.AddOnsDecorator;
import Items.AbstractItems.Burger;
import Items.AbstractItems.MenuItem;
import Items.AbstractItems.Pizza;
import java.util.ArrayList;

public class Billing {

    private final ArrayList<MenuItem> menuItems;
    private DiscountStrategy discountStrategy;

    public Billing(ArrayList<MenuItem> menuItems) {
        this.menuItems = menuItems;

        this.discountStrategy = new NoDiscount();
    }

    public void setDiscountStrategy(DiscountStrategy discountStrategy){
        this.discountStrategy = discountStrategy;
    }

    public double getTotalOldPrice(){
        double totalPrice = 0;
        for (MenuItem menuItem : menuItems) {
            totalPrice += menuItem.getPrice();
        }
        return totalPrice;
    }

    public double calculateFinalPrice(){
        boolean containsPizza = false;
        boolean containsBurger = false;
        for (MenuItem menuItem : menuItems) {
            MenuItem item;
            if (menuItem instanceof AddOnsDecorator) {
                item = ((AddOnsDecorator) menuItem).getWrappedItem();
            }else{
                item = menuItem;
            }
            if (item instanceof Pizza) {
                containsPizza = true;
                break;
            }else if (item instanceof Burger) {
                containsBurger = true;
            }
        }

        if (containsPizza) {
            setDiscountStrategy(new PizzaDiscount());
        }else if (containsBurger) {
            setDiscountStrategy(new BurgerDiscount());
        } else {
            setDiscountStrategy(new NoDiscount());
        }

        return discountStrategy.discount(getTotalOldPrice());
    }
}