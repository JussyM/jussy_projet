package model;

public abstract class Person {
    private final ActivityLevel level;
    private final int weight;
    private final int size;
    private final int age;

    /**
     * Constructor of Person
     * @param weight of the person
     * @param size of the person
     * @param age of the person
     * @param level activity level of the person
     */
    public Person(int weight, int size, int age, ActivityLevel level) {
        this.weight = weight;
        this.size = size;
        this.age = age;
        this.level = level;
    }

    /**
     * getter for weight
     * @return weight
     */
    public int getWeight() {
        return weight;
    }

    /**
     * getter for size
     * @return size
     */
    public int getSize() {
        return size;
    }

    /**
     * getter for age
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * return bmr result
     * @return result of bmr of a person
     */
    public abstract double getBMR();

    /**
     * return the nomber of calories of somebody
     * @return nb calories
     */
    public double myCalories() {
        return getBMR() * level.getValues();
    }
}
