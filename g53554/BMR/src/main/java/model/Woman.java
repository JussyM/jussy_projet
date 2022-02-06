package model;

public class Woman extends Person {
    /**
     * Constructor for woman object
     * @param weight of the woman
     * @param size of the woman
     * @param age of the woman
     * @param level activity level of the woman
     */
    public Woman(int weight, int size, int age, ActivityLevel level) {
        super(weight, size, age, level);
    }

    /**
     * return the bmr of a woman
     * @return bmr result
     */
    @Override
    public double getBMR() {
        return (9.6 * getWeight()) + (1.8* getSize()) - (4.7 * getAge() + 665);

    }
}
