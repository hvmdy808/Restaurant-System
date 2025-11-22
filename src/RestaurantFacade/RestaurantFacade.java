package RestaurantFacade;
import Observer.Kitchen;
import Observer.Waiter;
import Order.Order;

public class RestaurantFacade {
    Order order;

    public RestaurantFacade(Order order) {
        this.order = order;
    }

    public void placeOrder() {
        order.checkout();
        order.getSummaryReceipt();
        order.addObservers();
        order.getNotifier().notifyObservers();
        order.prepareItems();
    }
}
