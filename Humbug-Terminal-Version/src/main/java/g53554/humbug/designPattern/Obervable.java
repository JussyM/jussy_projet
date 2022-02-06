package g53554.humbug.designPattern;

import javafx.beans.Observable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Obervable {
    private final List<Observer> observers;

    public Obervable() {
        this.observers = new ArrayList<>();
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
