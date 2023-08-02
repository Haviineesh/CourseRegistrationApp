package views ;

import java.util.Scanner;

import model.AcademicStaff;
import model.Student;


public class AcademicStaffView implements Verification {

    public String getID(Scanner scanner) {
        System.out.println("Enter your academic staff ID: acad123");
        return scanner.nextLine();
    }

    public void noIDFound(String acadID) {
        System.out.println("Academic staff with ID " + acadID + " does not exist.");
    }

    public int displayAcademicStaffMenu(AcademicStaff academicStaff, Scanner scanner) {

        System.out.println("Academic Staff: " + academicStaff.getName());
        System.out.println("1) Create Subject");
        System.out.println("2) Delete Subject");
        System.out.println("3) Assign Lecturer to Subject");
        System.out.println("4) Switch Lecturer of Subject");
        System.out.println("5) Register New Student");
        System.out.println("6) View all Subjects");
        System.out.println("7) View all Lecturers");
        System.out.println("8) Logout");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        return choice;
    }

    public String getSubjectCode(Scanner scanner) {
        System.out.println("Enter the subject code: ");
        return scanner.nextLine();
    }

    public String getSubjectName(Scanner scanner) {
        System.out.println("Enter the subject name: ");
        return scanner.nextLine();
    }

    public String getSubjectCredit(Scanner scanner) {
        System.out.println("Enter the subject credit: ");
        return scanner.nextLine();
    }

    public String getLecturerID(Scanner scanner) {
        System.out.println("Enter the lecturer ID: ");
        return scanner.nextLine();
    }

    public Student addNewStudent(Scanner scanner) {
        System.out.println("Enter Student name: ");
        String name = scanner.nextLine();
        System.out.println("Enter student age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter student address: ");
        String address = scanner.nextLine();
        System.out.println("Enter student matric number: ");
        String matricNumber = scanner.nextLine();

        return new Student(name, age, address, matricNumber);
    }
}
