package model;

public class Subject {
    private String code;
    private String subName;
    private String credit;
    private String lecturerID;

    public Subject(String code, String subName, String credit) {
        this.code = code;
        this.subName = subName;
        this.credit = credit;
    }

    public Subject(String code, String subName, String credit, String lecturerID) {
        this(code, subName, credit);
        this.lecturerID = lecturerID;
    }

    public String getCode() {
        return code;
    }

    public String getSubName() {
        return subName;
    }

    public String getCredit() {
        return credit;
    }

    public String getLecturerID() {
        return lecturerID;
    }

    public void setLecturerID(String lecturerID) {
        this.lecturerID = lecturerID;
    }
}