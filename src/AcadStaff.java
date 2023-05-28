import java.util.List;
import java.util.ArrayList;

public class AcadStaff extends User {

    private String acadID;
    private List<Subject> subList;
    private List<Lecturer> lecList;

    public AcadStaff(String name, String acadID) {
        super(name);
        this.acadID = acadID;
        subList = new ArrayList<>();
        lecList = new ArrayList<>();
    }

    public void createSubject(String code, String subName, String credit) {
        subList.add(new Subject(code, subName, credit));
        System.out.println("Subject created: " + subName);
    }

    public void registerlecList(String name, int lectID) {
        lecList.add(new Lecturer(name, lectID));
        System.out.println("registration success: " + name);
    }

    public void createSubjectAndlecList(String code, String subName, String credit, String name, int lectID) {
        Subject subject = findSubjectByCode(code);
        if (subject == null) {
            subList.add(new Subject(code, subName, credit, name, lectID));
        }
        Lecturer lecturer = findLecturerByID(lectID);
        if (lecturer == null) {
            lecList.add(new Lecturer(name, lectID));
        }
        System.out.println("New subject added with lecList");
    }

    public void changeSubLecturer(String code, String name, int lectID) {
        Subject subject = findSubjectByCode(code);

        if (subject != null) {
            Lecturer lecturer = findLecturerByID(lectID);

            if (lecturer != null) {
                subject.setLecturer(name, lectID);
                System.out.println("Lecturer '" + name + "' is now assigned to subject code " + code);
            } else {
                lecturer = new Lecturer(name, lectID);
                lecList.add(lecturer);
                subject.setLecturer(lecturer);
                System.out.println("Lecturer '" + name + "' registered and assigned to subject code " + code);
            }
        } else {
            System.out.println("Subject '" + code + "' not found. Please add the subject first.");
        }
    }

    private Subject findSubjectByCode(String code) {
        for (Subject subject : subList) {
            if (subject.getCode().equals(code)) {
                return subject;
            }
        }
        return null;
    }

    private Lecturer findLecturerByID(int lectID) {
        for (Lecturer lecturer : lecList) {
            if (lecturer.getLectID() == lectID) {
                return lecturer;
            }
        }
        return null;
    }

}
