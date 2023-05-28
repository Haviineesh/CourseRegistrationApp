
public class Lecturer extends User {

    private int LectID;

    // constructor

    public Lecturer() {
    }

    public Lecturer(String name, int lectID) {
        super(name);
        this.LectID = lectID;
    }

    // make getter and setter

    public int getLectID() {
        return LectID;
    }

    public void setLectID(int lectID) {
        LectID = lectID;
    }

    @Override
    public String toString() {
        return "name= " + super.getname() + "ID: " + LectID;
    }

}