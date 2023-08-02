package controller;

import java.util.Scanner;

import main.App;
import views.*;
import model.*;

public class AcademicStaffController {

    public void handleAcademicStaff(Scanner scanner) {
        GeneralView generalView = new GeneralView();
        AcademicStaffView academicStaffView = new AcademicStaffView();

        String acadID = academicStaffView.getID(scanner);

        AcademicStaff academicStaff = findAcademicStaffByID(acadID);

        if (academicStaff == null) {
            academicStaffView.noIDFound(acadID);
            return;
        }

        boolean loggedIn = true;

        while (loggedIn) {
            int choice = academicStaffView.displayAcademicStaffMenu(academicStaff, scanner);

            switch (choice) {
                case 1:
                    String code = academicStaffView.getSubjectCode(scanner);
                    String subName = academicStaffView.getSubjectName(scanner);
                    String credit = academicStaffView.getSubjectCredit(scanner);
                    academicStaff.createSubject(code, subName, credit);
                    break;
                case 2:
                    String codeToDelete = academicStaffView.getSubjectCode(scanner);
                    academicStaff.deleteSubject(codeToDelete);
                    break;
                case 3:
                    viewAvailableSubjects();
                    String codeToAssign = academicStaffView.getSubjectCode(scanner);
                    String lecturerID = academicStaffView.getLecturerID(scanner);
                    academicStaff.assignLecturerToSubject(codeToAssign, lecturerID);
                    break;
                case 4:
                    viewAvailableSubjects();
                    String codeToSwitch = academicStaffView.getSubjectCode(scanner);
                    String newLecturerID = academicStaffView.getLecturerID(scanner);
                    academicStaff.switchLecturerOfSubject(codeToSwitch, newLecturerID);
                    break;
                case 5:
                    App.students.add(academicStaffView.addNewStudent(scanner));
                    break;
                case 6:
                    viewAvailableSubjects();
                    break;
                case 7:
                    viewAvailableLecturers();
                    break;
                case 8:
                    loggedIn = false;
                    break;
                default:
                    generalView.invalidMessage();
                    break;
            }
        }

        generalView.logoutMessage();
    }

    private void viewAvailableLecturers() {
        if (App.lecturers.isEmpty()) {
            System.out.println("No lecturers available.");
        } else {
            System.out.println("Lecturers:");
            int i = 1;
            for (Lecturer lecturer : App.lecturers) {
                System.out.println(i + lecturer.toString());
                System.out.println("------------------------");
                i++;
            }
        }
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

    private static AcademicStaff findAcademicStaffByID(String acadID) {
        for (AcademicStaff academicStaff : App.academicStaffs) {
            if (academicStaff.getAcadID().equals(acadID)) {
                return academicStaff;
            }
        }
        return null;
    }
}
