package model;

import main.App;

public class AcademicStaff extends User {
    private String acadID;

    public AcademicStaff(String name, int age, String address, String acadID) {
        super(name, age, address);
        this.acadID = acadID;
    }

    public String getAcadID() {
        return acadID;
    }

    public void createSubject(String code, String subName, String credit) {
        Subject subject = findSubjectByCode(code);
        if (subject == null) {
            Subject newSubject = new Subject(code, subName, credit, null);
            App.subjects.add(newSubject);
            System.out.println("Subject created successfully.");
        } else {
            System.out.println("Subject with code " + code + " already exists.");
        }
    }

    public void deleteSubject(String code) {
        Subject subject = findSubjectByCode(code);
        if (subject != null) {
            if (subject.getLecturerID() != null) {
                System.out.println("Subject with code " + code
                        + " is already assigned to a lecturer. Unassign the lecturer before deleting the subject.");
            } else {
                App.subjects.remove(subject);
                System.out.println("Subject with code " + code + " deleted successfully.");
            }
        } else {
            System.out.println("Subject with code " + code + " does not exist.");
        }
    }

    public void assignLecturerToSubject(String code, String lecturerID) {
        Subject subject = findSubjectByCode(code);
        if (subject != null) {
            if (subject.getLecturerID() != null) {
                System.out.println("Subject with code " + code
                        + " is already assigned to a lecturer. Use 'Switch Lecturer of Subject' to change the lecturer.");
            } else {
                Lecturer lecturer = findLecturerByID(lecturerID);
                if (lecturer != null) {
                    subject.setLecturerID(lecturerID);
                    lecturer.getTeachingSubjects().add(subject);
                    System.out.println("Lecturer with ID " + lecturerID + " assigned to subject with code " + code
                            + " successfully.");
                } else {
                    System.out.println("Lecturer with ID " + lecturerID + " does not exist.");
                }
            }
        } else {
            System.out.println("Subject with code " + code + " does not exist.");
        }
    }

    public void switchLecturerOfSubject(String code, String newLecturerID) {
        Subject subject = findSubjectByCode(code);
        if (subject != null) {
            if (subject.getLecturerID() != null) {
                Lecturer currentLecturer = findLecturerByID(subject.getLecturerID());
                if (currentLecturer != null) {
                    Lecturer newLecturer = findLecturerByID(newLecturerID);
                    if (newLecturer != null) {
                        subject.setLecturerID(newLecturerID);
                        currentLecturer.getTeachingSubjects().remove(subject);
                        newLecturer.getTeachingSubjects().add(subject);
                        System.out.println("Lecturer switched successfully.");
                    } else {
                        System.out.println("New lecturer with ID " + newLecturerID + " does not exist.");
                    }
                } else {
                    System.out.println("Current lecturer with ID " + subject.getLecturerID() + " does not exist.");
                }
            } else {
                System.out.println("Subject with code " + code + " is not assigned to any lecturer.");
            }
        } else {
            System.out.println("Subject with code " + code + " does not exist.");
        }
    }

    private Subject findSubjectByCode(String code) {
        for (Subject subject : App.subjects) {
            if (subject.getCode().equals(code)) {
                return subject;
            }
        }
        return null;
    }

    private Lecturer findLecturerByID(String lecturerID) {
        for (Lecturer lecturer : App.lecturers) {
            if (lecturer.getLecturerID().equals(lecturerID)) {
                return lecturer;
            }
        }
        return null;
    }

    @Override
    public void printInfo() {
        System.out.println("Class name AcademicStaff");
        System.out.println("Contains Academic Staff ID");
    }

    
}
