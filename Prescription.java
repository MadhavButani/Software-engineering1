package softwarefinal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;

public class Prescription {
    private int prescID;
    private String firstName;
    private String lastName;
    private String address;
    private float sphere;
    private float axis;
    private float cylinder;
    private Date examinationDate;
    private String optometrist;
    private String[] remarkTypes = {"Client", "Optometrist"};
    private ArrayList<String> postRemarks = new ArrayList<>();

    public Prescription(String firstName, String lastName, String address, float sphere, float axis, float cylinder, Date examinationDate, String optometrist) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.sphere = sphere;
        this.axis = axis;
        this.cylinder = cylinder;
        this.examinationDate = examinationDate;
        this.optometrist = optometrist;
    }

    public boolean addPrescription() {
        // Check condition 1: First Name and Last Name Length
        if (firstName.length() < 4 || firstName.length() > 15 || lastName.length() < 4 || lastName.length() > 15) {
            System.out.println("Invalid names");
            return false;
        }

        // Check condition 2: Address Length
        if (address.length() < 20) {
            System.out.println("Invalid address");
            return false;
        }

        // Check condition 3: Sphere, Cylinder, Axis validation
        if (sphere < -20.00 || sphere > 20.00 || cylinder < -4.00 || cylinder > 4.00 || axis < 0 || axis > 180) {
            System.out.println("Invalid sphere/cylinder/axis values");
            return false;
        }

        // Check condition 4: Date Format
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
        String formattedDate = dateFormat.format(examinationDate);
        if (formattedDate == null || formattedDate.isEmpty()) {
            System.out.println("Invalid date");
            return false;
        }

        // If all conditions are met, print the details (In place of file writing)
        System.out.println("Prescription Added:");
        System.out.println("Prescription ID: " + prescID);
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Address: " + address);
        System.out.println("Sphere: " + sphere);
        System.out.println("Cylinder: " + cylinder);
        System.out.println("Axis: " + axis);
        System.out.println("Examination Date: " + formattedDate);
        System.out.println("Optometrist: " + optometrist);
        System.out.println("-------------------------------");

        return true;
    }

    public static void main(String[] args) {
        // Test case
        // Use valid names and address length
        Prescription prescription = new Prescription(
            "Madhav", // First name (valid: 4-15 chars)
            "Butani", // Last name (valid: 4-15 chars)
            "456 Heatherton Road,Springvale South, 3172, Australia", // Valid address (min 20 chars)
            -1.5f, // Valid sphere (-20.00 to +20.00)
            90f, // Valid axis (0 to 180)
            -2.0f, // Valid cylinder (-4.00 to +4.00)
            new Date(), // Current date for eye examination
            "Dr. Ronny" // Optometrist
        );
        prescription.addPrescription(); // This will pass all conditions and print the prescription
    }
}
