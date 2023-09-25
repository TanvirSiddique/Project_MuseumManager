package csc8011;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MuseumIO {
    private static Museum museum;

    public static void main(String[] args) {
        userEntry();
    }

    /**
     * Method that takes in user entry and perform different actions.
     * 1. Takes in user entered Museum name.
     * 2. Reads the input in the exhibits.csv file.
     * 3. Prints the summary of the Museum includes name and full details.
     *    Full details of list of exhibits with their respective value and year acquired.
     * 4. Prints the Museum statistics includes the first exhibit, highest-value exhibit and average value.
     */
    private static void userEntry() {
        museum = new Museum();
        boolean done = false;
        while (!done) {
            printMuseumMenu();
            try {
                Scanner userInput = new Scanner(System.in);
                int option = userInput.nextInt();

                switch (option) {
                    case 1:
                        enterMuseumName();
                        break;
                    case 2:
                        readExhibitsCSV();
                        break;
                    case 3:
                        printSummary();
                        break;
                    case 4:
                        printMuseumStatistics();
                        break;
                    case 5:
                        done = true;
                        break;
                    default:
                        System.out.println("Enter a valid option!");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Enter a number!");
            }
        }
    }

    /**
     * Prints out the Museum menu on the console.
     */
    private static void printMuseumMenu() {
        System.out.println("\nWelcome to the Exhibition!");
        System.out.println("1: Get name of the Museum");
        System.out.println("2: Read in list of Exhibits");
        System.out.println("3: Print out the Summary of Museum");
        System.out.println("4: Print Museum Statistics");
        System.out.println("5: Exit");
        System.out.print("Enter a serial number > ");
        System.out.println("");
    }

    /**
     * Takes in user entered Museum name.
     * Prints it to the console.
     * Also sets it to the museum object.
     */
    private static void enterMuseumName() {
        System.out.print("Enter the name of the Museum: ");
        Scanner userInput = new Scanner(System.in);
        String museumName;
        museumName= userInput.nextLine();
        museum.setName(museumName); // Setting the museum name
        System.out.print( "Museum name: " + museumName);
        System.out.println("");
    }

    /**
     * Reads the exhibits.csv file
     * Prints in the console
     */
    private static void readExhibitsCSV() {
        try {
            File input = new File("exhibits.csv");
            Scanner s = new Scanner(input);
            s.nextLine();

            // This while loop will iterate over the entries in exhibits.csv.
            // Create an Exhibit object for each entry
            while (s.hasNext()) {
                String[] line = s.nextLine().split(",");
                //Creating exhibit objects
                Exhibit e = new Exhibit(line[0], line[1], Integer.parseInt(line[2]), Double.parseDouble(line[3]));
                //Adding exhibit to museum
               museum.addExhibit(e);
            }

            System.out.println("Read in " + museum.getExhibitArrayList().size() + " Exhibits");
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }


    /**
     * Method to iterate over all exhibits.
     * Calling the printExhibit utility method to print out exhibit summary.
     * Prints the Summary (of the Museum) on the console.
     */
    private static void printSummary()
    {
        System.out.println( "Museum name: " + museum.getName());
        if (museum.getExhibitArrayList().size() > 0)
        {
            for (Exhibit item : museum.getExhibitArrayList())
            {
                item.printExhibit();
            }
        }
        else
        {
            System.out.println("No Exhibits!");
        }
    }

    /**
     * Method to print statistics on exhibits.
     */
    private static void printMuseumStatistics() {
        //Specifications headline
        System.out.println("The statistics on highest value, " +
                            "first exhibit acquired" +
                            " and " +
                            "average value of exhibits:");
        //Highest value exhibit
        System.out.println("Highest value of the exhibit: " +
                 museum.highestValue().getDescription() + " ("
                 + museum.highestValue().getID() + "), " + "£"
                 + museum.highestValue().getValue());
        // First exhibit acquired
        System.out.println("First exhibit acquired: " + museum.oldestItem().getDescription()+
                "(acquired " + museum.oldestItem().getYear() + ")");
        //Average value
        System.out.println("Average value of exhibits: £" + museum.averageValue());
    }
}
