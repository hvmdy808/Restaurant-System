package Payment;

public class Cash implements PaymentStrategy{
    @Override
    public void pay() {
        System.out.println("You are paying Cash");
    }
}
