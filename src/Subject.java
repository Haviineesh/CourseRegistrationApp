import java.util.ArrayList;
import java.util.List;

public class Subject {

    private String code;
    private String subName;
    private String credit;
    private Lecturer lecturer;
    private List<Student> studList;
    private final int MAX = 30;

    public Subject() {
        studList = new ArrayList<>();
    }

    public Subject(String code, String subName, String credit) {
        this();
        this.code = code;
        this.subName = subName;
        this.credit = credit;
    }

    public Subject(String code, String subName, String credit, String lecName, int lecID) {
        this();
        this.code = code;
        this.subName = subName;
        this.credit = credit;
        this.lecturer = new Lecturer(lecName, lecID);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code){
        this.code = code;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String name){
        this.subName = name;
    }

    public List<Student> getStudList() {
        return studList;
    }

    public void setLecturer(String lecName, int lecID) {
        this.lecturer = new Lecturer(lecName, lecID);
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }

    public Lecturer getLecturer() {
        return lecturer;
    }

    public void addStud(Student stud) {
        if (studList.size() < MAX) {
            studList.add(stud);
            System.out.println("Student added to the subject.");
        } else {
            System.out.println("Subject has reached the limit for the number of students.");
        }
    }

    public void removeStud(String studentName) {
        boolean removed = false;
        Student studentToRemove = null;

        for (Student student : studList) {
            if (student.getName().equals(studentName)) {
                studentToRemove = student;
                break;
            }
        }

        if (studentToRemove != null) {
            removed = studList.remove(studentToRemove);
        }

        if (removed) {
            System.out.println("Student '" + studentName + "' removed from the subject.");
        } else {
            System.out.println("Student '" + studentName + "' not found in the subject.");
        }
    }

    public void displayLecturer(){
        System.out.println("Name: " + lecturer.getname());
    }

    public void display() {
        System.out.println("Subject: " + subName);
        System.out.println("Code: " + code);
        System.out.println("Credit: " + credit);
        System.out.println("Students enrolled:");
        if (studList.isEmpty()) {
            System.out.println("No students enrolled in this subject.");
        } else {
            for (Student student : studList) {
                System.out.println(student.getName() + " - " + student.getMatric());
            }
        }
    }
}
