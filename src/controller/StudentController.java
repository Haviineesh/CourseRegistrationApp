package controller ;
import java.util.Scanner;

import main.App;
import views.*;
import model.*;

public class StudentController {
    StudentView studentView;
    GeneralView generalView;

    public StudentController() {
        this.studentView = new StudentView();
        this.generalView = new GeneralView();
    }

    public void handleStudent(Scanner scanner) {

        String matricNumber = studentView.getID(scanner);

        Student student = findStudentByMatricNumber(matricNumber);

        if (student == null) {
            studentView.noIDFound(matricNumber);
            return;
        }

        boolean loggedIn = true;

        while (loggedIn) {
            int choice = studentView.displayStudentMenu(student, scanner);

            switch (choice) {
                case 1:
                    student.viewEnrolledSubjects();
                    break;
                case 2:
                    viewAvailableSubjects();
                    student.registerSubject(studentView.getSubjectCode('R', scanner));
                    break;
                case 3:
                    student.viewEnrolledSubjects();
                    student.removeRegisteredSubject(studentView.getSubjectCode('D', scanner));
                    break;
                case 4:
                    student.viewGrades();
                    break;
                case 5:
                    loggedIn = false;
                    break;
                default:
                    generalView.invalidMessage();
                    break;
            }
        }

        generalView.logoutMessage();
    }

    private static Student findStudentByMatricNumber(String matricNumber) {
        for (Student student : App.students) {
            if (student.getMatricNumber().equals(matricNumber)) {
                return student;
            }
        }
        return null;
    }

    private static void viewAvailableSubjects() {
        if (App.subjects.isEmpty()) {
            System.out.println("No subjects available.");
        } else {
            System.out.println("Available Subjects:");
            for (Subject subject : App.subjects) {
                System.out.println("Subject Code: " + subject.getCode());
                System.out.println("Subject Name: " + subject.getSubName());
                System.out.println("Credit: " + subject.getCredit());
                System.out.println("Lecturer ID: " + subject.getLecturerID());
                System.out.println("------------------------");
            }
        }
    }
}