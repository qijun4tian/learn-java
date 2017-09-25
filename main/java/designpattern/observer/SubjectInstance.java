package designpattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qijun123 on 2017/9/25.
 */
public class SubjectInstance implements Subject {

    private List<Observer>  observers = new ArrayList<>();
    @Override
    public void registerObserver(Observer o) {
        observers.add(o);

    }

    @Override
    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if(i>=0) {
            observers.remove(i);
        }

    }

    @Override
    public void notifyObservers() {
        observers.forEach(o->o.update("subject is updated"));
    }

    public static void main(String[] args) {
        SubjectInstance subjectInstance = new SubjectInstance();
        ObserverA observerA = new ObserverA();
        ObserverB observerB = new ObserverB();
        ObserverC observerC = new ObserverC();
        subjectInstance.registerObserver(observerA);
        subjectInstance.registerObserver(observerB);
        subjectInstance.registerObserver(observerC);
        subjectInstance.notifyObservers();
        subjectInstance.removeObserver(observerA);
        subjectInstance.notifyObservers();


    }
}
