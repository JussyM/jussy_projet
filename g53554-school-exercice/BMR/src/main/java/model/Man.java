package model;

public class Man extends Person {
    /**
     * Constructor of a man instance
     * @param weight of the person
     * @param size of the person
     * @param age of the person
     * @param level activity level of the person
     */
    public Man(int weight, int size, int age, ActivityLevel level) {
        super(weight, size, age, level);
    }

    /**
     * return the BMR result of a man
     * @return type double
     */
    @Override
    public double getBMR() {
        return (13.7 * getWeight()) + (5 * getSize()) - (6.8 * getAge() + 66);
    }
}
