package designPattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The type Observable.
 */
public abstract class Observable {
    private final List<Observer> observers;

    /**
     * Instantiates a new Observable.
     */
    public Observable() {
        observers = new ArrayList<>();
    }

    /**
     * Register observers.
     *
     * @param observer the observer
     */
    public void registerObservers(Observer observer) {
        Objects.requireNonNull(observer, Observable.class.getName()
                + " 's " + observer.getClass().getName() + " is null");
        observers.add(observer);
    }

    /**
     * Notify observers.
     *
     * @param args the args
     */
    public void notifyObservers(Object args) {
        observers.forEach(observer -> observer.update(args));
    }
}
