package csc8011;

import java.util.ArrayList;

public class Museum {
    private String name;
    private ArrayList<Exhibit> exhibitArrayList = new ArrayList<>();

    public Museum (String name) {
        this.name = name;
    }
    public Museum () {
        this.name = "museumName";
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName()
    {
        return name;
    }


    public ArrayList<Exhibit> getExhibitArrayList ( ) {
        return exhibitArrayList;
    }
    /**
     * Method to add an exhibit to the museum exhibit list.
     * @param a     represent addExhibit
     * @return      exhibit to the list
     */
    public boolean addExhibit(Exhibit a)
    {
        return exhibitArrayList.add(a);
    }

    /**
     * Method to find the exhibit with the highest value.
     * @return      the highest value exhibit
     */
    public Exhibit highestValue() {
        Exhibit highValue = exhibitArrayList.get(0);
        for (Exhibit i: exhibitArrayList)
            if (i.getValue() > highValue.getValue()) {
                highValue = i;
            }
        return highValue;
    }

    /**
     * Method to find the first exhibit.
     * @return  the first exhibit item
     */
    public Exhibit oldestItem() {
        Exhibit firstItem = exhibitArrayList.get(0);
        for (Exhibit i: exhibitArrayList)
            if (i.getYear() < firstItem.getYear()) {
                firstItem = i;
            }
        return  firstItem;
    }

    /**
     * Method to find the average value of all exhibits.
     * @return    the average value of exhibits
     */
    public double averageValue() {
        double avgValue = 0.0;
        for (Exhibit i: exhibitArrayList) {
            avgValue = avgValue + i.getValue();
        }
        avgValue = avgValue / exhibitArrayList.size();
        return avgValue;
    }
}

