//OOP JAVA Project COURSE REGISTRATION 

/*
 * Default IDs:
 *   Student: stud123
 *   Academic Staff: acad123
 *   Lecturer: lec123
 *   Lecturer: lec2
 */

package main;

import java.util.*;
import controller.*;
import model.*;
import views.GeneralView;

public class App {
    public static ArrayList<Subject> subjects = new ArrayList<>();
    public static ArrayList<Student> students = new ArrayList<>();
    public static ArrayList<Lecturer> lecturers = new ArrayList<>();
    public static Vector<AcademicStaff> academicStaffs = new Vector<>();

    public static void main(String[] args) throws Exception {
        loadData();
        GeneralView generalView = new GeneralView();
        LecturerController lecturerController = new LecturerController();
        StudentController studentController = new StudentController();
        AcademicStaffController academicStaffController = new AcademicStaffController();
        boolean continuing = true;

        Scanner scanner = new Scanner(System.in);

        while (continuing) {
            int choice = generalView.displayMainMenu(scanner);

            switch (choice) {
                case 1:
                    studentController.handleStudent(scanner);
                    generalView.lineBreak();
                    break;
                case 2:
                    lecturerController.handleLecturer(scanner);
                    generalView.lineBreak();
                    break;
                case 3:
                    academicStaffController.handleAcademicStaff(scanner);
                    generalView.lineBreak();
                    break;
                default:
                    generalView.invalidMessage();
                    break;
            }
            if (!continuing) {
                break;
            }

            generalView.continueMessage();

            if (scanner.hasNextLine()) {
                String continueChoice = scanner.nextLine();
                if (!continueChoice.equalsIgnoreCase("Y")) {
                    continuing = false;
                }
            } else {
                continuing = false;
            }
        }

        scanner.close();
    }

    protected static void loadData() {
        App.academicStaffs.add(new AcademicStaff("Jeff", 45, "No 59,UTM", "acad123"));
        App.students.add(new Student("Timmy", 22, "No 1, N24", "stud123"));
        App.lecturers.add(new Lecturer("George", 41, "No 3, Utm", "lec123"));
        App.lecturers.add(new Lecturer("Lim", 45, "No , Utm", "lec2"));
        App.subjects.add(new Subject("oop", "oop", "4"));
        App.subjects.add(new Subject("se", "se", "3"));
    }
}
