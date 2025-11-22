import Factories.KidsFactory;
import Factories.MenuFactory;
import Factories.NonVegFactory;
import Factories.VegFactory;
import Items.AbstractItems.MenuItem;
import Items.Extras.ExtraCheese;
import Items.Extras.ExtraSauce;
import Items.Extras.ExtraTopping;
import Order.Order;
import Order.Type;
import Payment.Cash;
import Payment.CreditCard;
import Payment.MobileWallet;
import Payment.PaymentStrategy;
import RestaurantFacade.RestaurantFacade;

import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("** Welcome to Restaurant **");

        Order order = new Order();

        boolean moreItems = true;

        while (moreItems) {

            MenuFactory menuFactory = askMenuFactory();

            while (true){
                System.out.println("Please choose the menu item: ");
                System.out.println("1. Pizza");
                System.out.println("2. Burger");
                System.out.println("3. Drink");
                int choice = getIntInput();
                if (choice == 1) {
                    MenuItem item = menuFactory.createPizza();
                    System.out.println("Do you need any extras? Any choice rather than 1,2,3 is considered as No");
                    System.out.println("1. Cheese");
                    System.out.println("2. Toppings");
                    System.out.println("3. Sauce");
                    System.out.println("4. No");
                    int choice2 = getIntInput();
                    if (choice2 == 1) {item = new ExtraCheese(item);}
                    else if (choice2 == 2) {item = new ExtraTopping(item);}
                    else if (choice2 == 3) {item = new ExtraSauce(item);}
                    order.addMenuItem(item);
                    break;
                }else if (choice == 2) {
                    MenuItem item = menuFactory.createBurger();
                    System.out.println("Do you need any extras? Any choice rather than 1,2 is considered as No");
                    System.out.println("1. Cheese");
                    System.out.println("2. Sauce");
                    System.out.println("3. No");
                    int choice2 = getIntInput();
                    if (choice2 == 1) {item = new ExtraCheese(item);}
                    else if (choice2 == 2) {item = new ExtraSauce(item);}
                    order.addMenuItem(item);
                    break;
                }else if (choice == 3) {
                    order.addMenuItem(menuFactory.createDrink());
                    break;
                }else{
                    System.out.println("Invalid item choice. Please try again.");
                }
            }

            System.out.println("Need another item? Any choice rather than 1 is considered as No");
            System.out.println("1. Yes");
            System.out.println("2. No");

            int again = getIntInput();
            moreItems = (again == 1);
        }
        askOrderType(order);
        System.out.println("Total after discounts is " + order.calculateFinalPrice());
        order.setPaymentStrategy(askPaymentStrategy());
        RestaurantFacade facade = new RestaurantFacade(order);
        facade.placeOrder();
    }

    private static int getIntInput() {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input, enter a number:");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public static void askOrderType(Order order) {
        while (true) {
            System.out.println("Choose order type:");
            System.out.println("1. Dine-in");
            System.out.println("2. Delivery");
            System.out.println("3. Takeaway");

            int choice = getIntInput();
            if (choice == 1) {
                order.setType(Type.Dine_in);
                break;
            } else if (choice == 2) {
                order.setType(Type.Delivery);
                break;
            } else if (choice == 3) {
                order.setType(Type.Takeaway);
                break;
            } else{
                System.out.println("Invalid choice.");
            }
        }
    }

    public static MenuFactory askMenuFactory() {
        while (true) {
            System.out.println("Choose menu category:");
            System.out.println("1. Vegan");
            System.out.println("2. Non-Vegan");
            System.out.println("3. Kids");

            switch (getIntInput()) {
                case 1 -> { return new VegFactory(); }
                case 2 -> { return new NonVegFactory(); }
                case 3 -> { return new KidsFactory(); }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    public static PaymentStrategy askPaymentStrategy() {
        while (true) {
            System.out.println("Choose payment method:");
            System.out.println("1. Cash");
            System.out.println("2. Credit Card");
            System.out.println("3. Mobile Wallet");

            switch (getIntInput()) {
                case 1 -> { return new Cash(); }
                case 2 -> { return new CreditCard(); }
                case 3 -> { return new MobileWallet(); }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}
