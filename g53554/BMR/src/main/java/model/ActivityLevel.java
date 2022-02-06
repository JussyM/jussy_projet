package model;

public enum ActivityLevel {
    SEDENTARY(1.2), NOT_VERY_ACTIVE(1.375),
    ACTIVE(1.55), VERY_ACTIVE(1.725), HIGHLY_ACTIVE(1.9);
    private final double values;

    /**
     * Construct the activity level with each accurate values
     * @param values of each activity level
     */
    private ActivityLevel(double values) {
        this.values = values;
    }

    /**
     * getter for value
     * @return values
     */
    public double getValues() {
        return values;
    }
}
