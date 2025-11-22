package Items.AbstractItems;

public abstract class AddOnsDecorator implements MenuItem{
    protected MenuItem item;
    public AddOnsDecorator(MenuItem item){
        this.item = item;
    }
    @Override
    public abstract double getPrice();
    @Override
    public abstract String getName();
    @Override
    public void prepare(){
        System.out.println("Preparing " + this.getName());
    }
    public MenuItem getWrappedItem(){
        return item;
    }
}
