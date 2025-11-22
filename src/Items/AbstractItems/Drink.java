package Items.AbstractItems;

public abstract class Drink implements MenuItem{
    @Override
    public abstract double getPrice();
    @Override
    public abstract String getName();
    @Override
    public void prepare(){
        System.out.println("Preparing " + getName());
    }
}
