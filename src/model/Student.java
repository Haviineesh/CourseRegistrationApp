package model;
import java.util.*;

import main.App;

public class Student extends User {
    private String matricNumber;
    private List<Subject> enrolledSubjects;
    private Map<Subject, String> grades;

    public Student(String name, int age, String address, String matricNumber) {
        super(name, age, address);
        this.matricNumber = matricNumber;
        this.enrolledSubjects = new ArrayList<>();
        this.grades = new HashMap<>();
    }

    public String getMatricNumber() {
        return matricNumber;
    }

    public void registerSubject(String subjectCode) {
        Subject subject = findSubjectByCode(subjectCode);
        if (subject != null) {
            if (!enrolledSubjects.contains(subject)) {
                enrolledSubjects.add(subject);
                System.out.println("Subject with code " + subjectCode + " registered successfully.");
            } else {
                System.out.println("You are already enrolled in subject with code " + subjectCode + ".");
            }
        } else {
            System.out.println("Subject with code " + subjectCode + " does not exist.");
        }
    }

    public void removeRegisteredSubject(String subjectCode) {
        Subject subject = findSubjectByCode(subjectCode);
        if (subject != null) {
            if (enrolledSubjects.contains(subject)) {
                enrolledSubjects.remove(subject);
                grades.remove(subject);
                System.out.println("Subject with code " + subjectCode + " removed successfully.");
            } else {
                System.out.println("You are not enrolled in subject with code " + subjectCode + ".");
            }
        } else {
            System.out.println("Subject with code " + subjectCode + " does not exist.");
        }
    }

    public List<Subject> getEnrolledSubjects() {
        return enrolledSubjects;
    }

    public void viewEnrolledSubjects() {
        if (enrolledSubjects.isEmpty()) {
            System.out.println("No subjects enrolled.");
        } else {
            System.out.println("Enrolled Subjects:");
            for (Subject subject : enrolledSubjects) {
                System.out.println("Subject Code: " + subject.getCode());
                System.out.println("Subject Name: " + subject.getSubName());
                System.out.println("Credit: " + subject.getCredit());
                System.out.println("------------------------");
            }
        }
    }

    public void viewGrades() {
        if (grades.isEmpty()) {
            System.out.println("No grades available.");
        } else {
            System.out.println("Grades:");
            for (Map.Entry<Subject, String> entry : grades.entrySet()) {
                Subject subject = entry.getKey();
                String grade = entry.getValue();
                System.out.println("Subject Code: " + subject.getCode());
                System.out.println("Subject Name: " + subject.getSubName());
                System.out.println("Credit: " + subject.getCredit());
                System.out.println("Grade: " + grade);
                System.out.println("------------------------");
            }
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

    public void addGrade(Subject subject, String grade) {
        grades.put(subject, grade);
    }

    @Override
    public String toString() {
        return "Student [matricNumber=" + matricNumber + ", enrolledSubjects=" + enrolledSubjects + ", grades=" + grades
                + "]";
    }

    @Override
    public void printInfo() {
       System.out.println("Class Name Student");
       System.out.println(" Contains Matric number, enrolled subjects and grades");
    }
}