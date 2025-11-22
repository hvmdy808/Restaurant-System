package Payment;

public class MobileWallet implements PaymentStrategy{
    @Override
    public void pay() {
        System.out.println("You are paying via mobile wallet");
    }
}
