package Items.AbstractItems;

public abstract class AddOnsDecorator implements MenuItem{
    private MenuItem item;
    @Override
    public abstract double getPrice();
    @Override
    public abstract String getName();
}
