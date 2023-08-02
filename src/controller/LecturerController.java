package controller ;
import views.*;
import model.*;

import java.util.Scanner;

import main.App;

public class LecturerController {
    LecturerView lecturerView;
    GeneralView generalView;

    public LecturerController() {
        this.lecturerView = new LecturerView();
        this.generalView = new GeneralView();
    }

    public void handleLecturer(Scanner scanner) {

        String lecturerID = lecturerView.getID(scanner);

        Lecturer lecturer = findLecturerByID(lecturerID);

        if (lecturer == null) {
            lecturerView.noIDFound(lecturerID);
            return;
        }

        boolean loggedIn = true;

        while (loggedIn) {
            int choice = lecturerView.displayLecturerMenu(lecturer, scanner);

            switch (choice) {
                case 1:
                    lecturer.viewTeachingSubjects();
                    break;
                case 2:
                    lecturer.viewTeachingSubjects();
                    lecturer.gradeStudent(lecturerView.getSubjectCodeToGrade(scanner),scanner);
                    break;
                case 3:
                    lecturer.viewTeachingSubjects();
                    lecturer.viewStudentList(lecturerView.getSubjectCodeToList(scanner));
                    break;
                case 4:
                    loggedIn = false;
                    break;
                default:
                    generalView.invalidMessage();
                    break;
            }
        }
        generalView.logoutMessage();
    }

    private static Lecturer findLecturerByID(String lecturerID) {
        for (Lecturer lecturer : App.lecturers) {
            if (lecturer.getLecturerID().equals(lecturerID)) {
                return lecturer;
            }
        }
        return null;
    }
}