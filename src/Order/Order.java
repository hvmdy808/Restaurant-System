package Order;
// Removed unused imports: Discount.BurgerDiscount, Discount.NoDiscount, Discount.PizzaDiscount
import Discount.DiscountStrategy; // Maintained for type hinting
// Removed unused imports: Items.AbstractItems.AddOnsDecorator, Items.AbstractItems.Burger, Items.AbstractItems.Pizza
import Items.AbstractItems.MenuItem;
import Observer.Kitchen;
import Observer.OrderNotifier;
import Observer.Waiter;
import Payment.PaymentStrategy;
import Order.Billing; // Import the new Billing class
import java.util.ArrayList;

public class Order {
    private ArrayList<MenuItem> menuItems;
    private OrderNotifier orderNotifier;
    private Type type;
    private PaymentStrategy paymentStrategy;
    // Removed private DiscountStrategy discountStrategy;

    private Billing billing; // New Billing object

    public Order() {
        menuItems = new ArrayList<>();
        orderNotifier = new OrderNotifier();
        billing = new Billing(menuItems); // Initialize the Billing with menuItems
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

    // Retained for compatibility with Main, but now sets strategy in Billing object
/*    public void setDiscountStrategy(DiscountStrategy discountStrategy){
        // Delegate setting the discount strategy to the Billing object
        billing.setDiscountStrategy(discountStrategy);
    }*/

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
        return billing.getTotalOldPrice();
    }

    public void checkout(){
        paymentStrategy.pay();
    }


    public double calculateFinalPrice(){
        return billing.calculateFinalPrice();
    }

    public void getSummaryReceipt(){
        System.out.println("-- Order Receipt --");
        System.out.println(type + " Order");
        System.out.println("Items: ");
        for (MenuItem menuItem : menuItems) {
            System.out.println(menuItem.getName() + ": " + menuItem.getPrice() + " $");
        }
        System.out.println("Total price before discount: " + getTotalOldPrice() + " $");
        // Calls the new calculateFinalPrice, which delegates to the Billing object
        System.out.println("Total price after discount: " + calculateFinalPrice() + " $");
        System.out.println("Payment method: " + paymentStrategy.getType());
    }
}