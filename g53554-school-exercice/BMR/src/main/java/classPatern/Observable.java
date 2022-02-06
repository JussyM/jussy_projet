package classPatern;

/**
 * The interface Observable.
 */
public interface Observable {
    /**
     * Design patterns Observer Observable use it notify all the Observers to update them self
     *
     * @param args the args that's update
     */
    void notifyObservers(Object args);

    /**
     * Register observer. use to register all the observer
     *
     * @param observer the observer that need to be register
     */
    void registerObserver(Observer observer);
}
