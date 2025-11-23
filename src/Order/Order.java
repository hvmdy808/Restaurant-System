package Order;
import Items.AbstractItems.MenuItem;
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


    private Billing billing;

    public Order() {
        menuItems = new ArrayList<>();
        orderNotifier = new OrderNotifier();
        billing = new Billing(menuItems);
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
        System.out.println("Total price after discount: " + calculateFinalPrice() + " $");
        System.out.println("Payment method: " + paymentStrategy.getType());
    }
}