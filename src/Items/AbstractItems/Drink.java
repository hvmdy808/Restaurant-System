package Items.AbstractItems;

public abstract class Drink implements MenuItem{
    @Override
    public abstract double getPrice();
    @Override
    public abstract String getName();
}
