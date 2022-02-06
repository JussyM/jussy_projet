package model;

import classPatern.Observable;
import classPatern.Observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The type Bmr.
 */
public class BMR implements Observable {
    private List<Observer> observers;
    private Person person;

    /**
     * Instantiates a new Bmr.
     *
     * @param person the person
     */
    public BMR(Person person) {
        this.person = person;
        observers = new ArrayList<>();
    }
    /**
     * Design patterns Observer Observable use it notify all the Observers to update them self
     *
     * @param args the args that's update
     */
    @Override
    public void notifyObservers(Object args) {
        observers.forEach(x -> x.update(args));
    }

    /**
     * Gets bmr.
     *
     * @return the bmr
     */
    public double getBMR() {
        return person.getBMR();
    }

    /**
     * Gets calories.
     *
     * @return the calories
     */
    public double getCalories() {
        return person.myCalories();
    }
    /**
     * Register observer. use to register all the observer
     *
     * @param observer the observer that need to be register
     */
    @Override
    public void registerObserver(Observer observer) {
        Objects.requireNonNull(observer, this.getClass().getName() + " 's " + observer.getClass().getName() + " is null");
        observers.add(observer);

    }
}
