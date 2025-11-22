package Observer;

import java.util.Observable;

public class Kitchen implements Observer {
    public void respond() {
        System.out.println("Kitchen is ready");
    }
}
