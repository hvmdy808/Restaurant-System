package Observer;

import java.util.ArrayList;

public class OrderNotifier {
    private ArrayList<Observer> observers;

    public OrderNotifier() {
        observers = new ArrayList<Observer>();
    }

    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.respond();
        }
    }
}
