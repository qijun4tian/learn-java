package designpattern.observer;

/**
 * Created by qijun123 on 2017/9/25.
 */
public class ObserverA implements Observer {
    //@Override
    //public void update(String info) {
    //
    //}
    @Override
    public void update(String info) {
        System.out.println("ObserverA" + info);
    }
}
