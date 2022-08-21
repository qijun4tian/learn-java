package java.designpattern.observer;

/**
 * Created by qijun123 on 2017/9/25.
 */
public interface Subject {
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObservers();
}
