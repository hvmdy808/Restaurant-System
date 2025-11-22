package Payment;

public interface PaymentStrategy {
    String getType();
    void pay();
}
