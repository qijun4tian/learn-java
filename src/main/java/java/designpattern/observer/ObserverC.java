package java.designpattern.observer;

/**
 * Created by qijun123 on 2017/9/25.
 */
public class ObserverC implements Observer {
    @Override
    public void update(String info) {
        System.out.println("ObserverC"+info);
    }
}
