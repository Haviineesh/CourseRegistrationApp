public class Student extends User {

  private String matric;
  
  // tambah postgrade and undergrade
  // jdkan sebagai composition

  // constructor

  public Student(String name, int age, String matric) {
    super(name, age);
    this.matric = matric;

  }

  // getter
  public String getName() {
    return super.getname();
  }

  public String getMatriks() {
    return matric;
  }

  public void setMatriks(String newMatriks) {
    this.matric = newMatriks;
  }

  public String getMatric() {
    return matric;
  }

  public void setMatric(String matric) {
    this.matric = matric;
  }

}