package softwarefinal;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Remark {
    private int prescID;
    private String firstName;
    private String lastName;
    private String address;
    private float sphere;
    private float axis;
    private float cylinder;
    private String optometrist;
    private ArrayList<String> remarks = new ArrayList<>(); // Stores remarks
    private ArrayList<String> remarkCategories = new ArrayList<>(); // Stores categories for each remark

    public Remark(String firstName, String lastName, String address, float sphere, float axis, float cylinder, String optometrist) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.sphere = sphere;
        this.axis = axis;
        this.cylinder = cylinder;
        this.optometrist = optometrist;
    }

    public boolean addRemark(String remarkText, String category) {
        // Check if the number of remarks is already 2
        if (remarks.size() >= 2) {
            System.out.println("Cannot add more than 2 remarks");
            return false;
        }

        // Condition 1: Check if the remark text has 6-20 words
        String[] words = remarkText.trim().split("\\s+");
        if (words.length < 6 || words.length > 20) {
            System.out.println("Invalid remark: It must contain between 6 and 20 words");
            return false;
        }

        // Check if the first word starts with an uppercase letter
        if (!Character.isUpperCase(words[0].charAt(0))) {
            System.out.println("Invalid remark: The first word must start with an uppercase letter");
            return false;
        }

        // Condition 2: Validate the remark category ("client" or "optometrist")
        if (!category.equalsIgnoreCase("client") && !category.equalsIgnoreCase("optometrist")) {
            System.out.println("Invalid category: It must be either 'client' or 'optometrist'");
            return false;
        }

        // Add the remark and its category to the list
        remarks.add(remarkText);
        remarkCategories.add(category);

        // Writing the remark to a TXT file (e.g., review.txt)
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("review.txt", true))) {
            writer.write("Remark: " + remarkText + " (Category: " + category + ")");
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        // Return true if everything is successful
        System.out.println("Remark added: " + remarkText + " (Category: " + category + ")");
        return true;
    }

    // Main method to test the class
    public static void main(String[] args) {
        // Test case 1: Valid remarks
        Remark remark = new Remark("Johnathan", "Smith", "1234 Elm Street, Melbourne, 3000, Australia", -1.5f, 90f, -2.0f, "Dr. Williams");

        // Valid remark 1
        remark.addRemark("This is a valid remark for the client.", "client");

        // Valid remark 2
        remark.addRemark("A second remark is being added by the optometrist.", "optometrist");

        // Attempt to add a third remark (should fail)
        remark.addRemark("This is an extra remark and should not be allowed.", "client"); // Should fail (Cannot add more than 2 remarks)
    }
}


