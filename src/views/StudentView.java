package views;
import java.util.Scanner;

import model.Student;

public class StudentView implements Verification {

    public String getID(Scanner scanner) {
        System.out.println("Enter your student ID: ");
        return scanner.nextLine();
    }

    public void noIDFound(String matricNumber) {
        System.out.println("Student with matric " + matricNumber + " does not exist.");
    }

    public int displayStudentMenu(Student student, Scanner scanner) {

        System.out.println("Student: " + student.getName());
        System.out.println("1) View Enrolled Subjects");
        System.out.println("2) Register Subject");
        System.out.println("3) Drop Subject");
        System.out.println("4) View Grades");
        System.out.println("5) Logout");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        return choice;
    }

    public String getSubjectCode(char c, Scanner scanner) {
        if (c == 'R') {
            System.out.println("Enter the subject code to register: ");
            return scanner.nextLine();
        } else if(c =='D') {
            System.out.println("Enter the subject code to drop: ");
            return scanner.nextLine();
        }
        else{
            System.out.println("Enter the subject code: ");
            return scanner.nextLine();
        }
    }

}
