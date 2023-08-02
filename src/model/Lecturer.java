package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import main.App;

public class Lecturer extends User {
    private String lecturerID;
    private List<Subject> teachingSubjects;

    public Lecturer(String name, int age, String address, String lecturerID) {
        super(name, age, address);
        this.lecturerID = lecturerID;
        this.teachingSubjects = new ArrayList<>();
    }

    public String getLecturerID() {
        return lecturerID;
    }

    public void gradeStudent(String subjectCode, Scanner scanner) {
        Subject subject = findTeachingSubjectByCode(subjectCode);
        if (subject != null) {
            System.out.println("Grading students for subject with code " + subjectCode + ".");
            List<Student> studentList = findStudentsBySubject(subject);
            if (studentList.isEmpty()) {
                System.out.println("No students found for subject with code " + subjectCode + ".");
            } else {
                for (Student student : studentList) {
                    System.out.println("Enter grade for student " + student.getName() + ":");
                    String grade = scanner.nextLine();
                    student.addGrade(subject, grade);
                }
                System.out.println("Grades updated successfully.");
            }
        } else {
            System.out.println("You are not teaching subject with code " + subjectCode + ".");
        }
    }

    public void viewTeachingSubjects() {
        if (teachingSubjects.isEmpty()) {
            System.out.println("No teaching subjects.");
        } else {
            System.out.println("Teaching Subjects:");
            for (Subject subject : teachingSubjects) {
                System.out.println("Subject Code: " + subject.getCode());
                System.out.println("Subject Name: " + subject.getSubName());
                System.out.println("Credit: " + subject.getCredit());
                System.out.println("------------------------");
            }
        }
    }

    public void viewStudentList(String subjectCode) {
        Subject subject = findTeachingSubjectByCode(subjectCode);
        if (subject != null) {
            List<Student> studentList = findStudentsBySubject(subject);
            if (studentList.isEmpty()) {
                System.out.println("No students found for subject with code " + subjectCode + ".");
            } else {
                System.out.println("Student List for subject with code " + subjectCode + ":");
                for (Student student : studentList) {
                    System.out.println("Student Name: " + student.getName());
                    System.out.println("Matric Number: " + student.getMatricNumber());
                    System.out.println("------------------------");
                }
            }
        } else {
            System.out.println("You are not teaching subject with code " + subjectCode + ".");
        }
    }

    public List<Subject> getTeachingSubjects() {
        return teachingSubjects;
    }

    private Subject findTeachingSubjectByCode(String code) {
        for (Subject subject : teachingSubjects) {
            if (subject.getCode().equals(code)) {
                return subject;
            }
        }
        return null;
    }

    private List<Student> findStudentsBySubject(Subject subject) {
        List<Student> studentList = new ArrayList<>();
        for (Student student : App.students) {
            if (student.getEnrolledSubjects().contains(subject)) {
                studentList.add(student);
            }
        }
        return studentList;
    }

    @Override
    public String toString() {
        String subName = "";
        for (Subject subject : teachingSubjects) {
            subName += subject.getSubName() + ", ";
        }

        return "    Name: " + super.getName() +
                "\n     Lecturer ID: " + lecturerID +
                "\n     teachingSubjects: " + subName;

    }

    @Override
    public void printInfo() {
        System.out.println("Class Name Lecturer");
        System.out.println("Contains Lecturer ID and list of Subjects Teaching ");
    }

}
