package Payment;

public class CreditCard implements PaymentStrategy{
    @Override
    public void pay() {
        System.out.println("You are paying via CreditCard");
    }
    public String getType(){
        return "Credit Card";
    }
}
