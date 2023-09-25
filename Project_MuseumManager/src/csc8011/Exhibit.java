package csc8011;

public class Exhibit {
    private String id;
    private String description;
    private int year;
    private double value;
    /**
     * Method for accessing Exhibit paramenters
     * @param id                the exhibit id
     * @param description       the exhibit description
     * @param year              the year exhibit acquired by museum
     * @param value             Value (in Pound Sterling) for the respective exhibit
     */
    public Exhibit(String id, String description, int year, double value) {
        this.id = id;
        this.description = description;
        this.year = year;
        this.value = value;
    }

    public String getID() {
        return id;
    }
    public String getDescription() {
        return description;
    }
    public int getYear() {
        return year;
    }
    public double getValue() {
        return value;
    }

    /**
     * Utility method to print out the Exhibit details
     */
    public void printExhibit() {
        System.out.println( "Exhibit ID: " + getID() + " Description: " + getDescription() +
                " Year acquired: " + getYear() + " Value: £" + getValue());
    }
}
