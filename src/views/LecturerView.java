package views ;
import java.util.Scanner;

import model.Lecturer;
public class LecturerView implements Verification{
    
    public String getID(Scanner scanner) {
        System.out.println("Enter your lecturer ID: ");
        return scanner.nextLine();
    }

    public void noIDFound(String lecturerID) {
        System.out.println("Lecturer with ID " + lecturerID + " does not exist.");
    }

    public int displayLecturerMenu(Lecturer lecturer, Scanner scanner) {
        System.out.println("Lecturer: " + lecturer.getName());
        System.out.println("1) View Teaching Subjects");
        System.out.println("2) Grade Student");
        System.out.println("3) View Student List");
        System.out.println("4) Logout");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        return choice;
    }

    public String getSubjectCodeToGrade(Scanner scanner) {
        System.out.println("Enter the subject code to grade: ");
        return scanner.nextLine();
    }

    public String getSubjectCodeToList(Scanner scanner) {
        System.out.println("Enter the subject code to view student list: ");
        return scanner.nextLine();
    }
}