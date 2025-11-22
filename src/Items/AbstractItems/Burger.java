package Items.AbstractItems;

public abstract class Burger implements MenuItem{
    @Override
    public abstract double getPrice();
    @Override
    public abstract String getName();
}
