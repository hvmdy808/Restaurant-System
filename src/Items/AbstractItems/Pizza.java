package Items.AbstractItems;

public abstract class Pizza implements MenuItem{
    @Override
    public abstract double getPrice();
    @Override
    public abstract String getName();
    @Override
    public void prepare(){
        System.out.println("Preparing " + this.getName());
    }
}
