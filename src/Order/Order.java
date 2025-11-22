package Order;
import Discount.BurgerDiscount;
import Discount.DiscountStrategy;
import Discount.NoDiscount;
import Discount.PizzaDiscount;
import Items.AbstractItems.AddOnsDecorator;
import Items.AbstractItems.Burger;
import Items.AbstractItems.MenuItem;
import Items.AbstractItems.Pizza;
import Observer.Kitchen;
import Observer.OrderNotifier;
import Observer.Waiter;
import Payment.PaymentStrategy;
import java.util.ArrayList;

public class Order {
    private ArrayList<MenuItem> menuItems;
    private OrderNotifier orderNotifier;
    private Type type;
    private PaymentStrategy paymentStrategy;
    private DiscountStrategy discountStrategy;

    public Order() {
        menuItems = new ArrayList<>();
        orderNotifier = new OrderNotifier();
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void addMenuItem(MenuItem menuItem) {
        menuItems.add(menuItem);
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy){
        this.paymentStrategy = paymentStrategy;
    }

    public void setDiscountStrategy(DiscountStrategy discountStrategy){
        this.discountStrategy = discountStrategy;
    }

    public void prepareItems() {
        for (MenuItem menuItem : menuItems) {
            menuItem.prepare();
        }
        System.out.println("Order Done!");
    }

    public OrderNotifier getNotifier(){
        return orderNotifier;
    }

    public void addObservers(){
        switch (type){
            case Dine_in -> {
                orderNotifier.subscribe(new Waiter());
                orderNotifier.subscribe(new Kitchen());
            }
            case Delivery, Takeaway -> {orderNotifier.subscribe(new Kitchen());}
        }
    }

    public double getTotalOldPrice(){
        double totalPrice = 0;
        for (MenuItem menuItem : menuItems) {
            totalPrice += menuItem.getPrice();
        }
        return totalPrice;
    }

    public void checkout(){
        paymentStrategy.pay();
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
        }
        if (!containsPizza && !containsBurger) {
            setDiscountStrategy(new NoDiscount());
        }

        return discountStrategy.discount(getTotalOldPrice());
    }

    public void getSummaryReceipt(){
        System.out.println("-- Order Receipt --");
        System.out.println(type + " Order");
        System.out.println("Items: ");
        for (MenuItem menuItem : menuItems) {
            System.out.println(menuItem.getName() + ": " + menuItem.getPrice() + " $");
        }
        System.out.println("Total price before discount: " + getTotalOldPrice() + " $");
        System.out.println("Total price after discount: " + calculateFinalPrice() + " $");
        System.out.println("Payment method: " + paymentStrategy.getType());
    }
}
