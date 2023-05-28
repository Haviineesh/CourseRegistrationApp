import java.util.Scanner;

public class App {
  private static Scanner scanner = new Scanner(System.in);
  private static AcadStaff staff = new AcadStaff("En.Ali", "AC01");

  public static void main(String[] args) throws Exception {
    boolean continuing = true;

    Scanner scanner = new Scanner(System.in);

    while (continuing) {

      System.out.println("Login as:");
      System.out.println("1) Student");
      // ask for matrik id
      // list out the detail for the student
      // list the current grade
      // 1) register subject
      // 2) drop subject
      System.out.println("2) Lecturer");
      // ask for lecturer id
      // select subject
      // select student
      // grade student
      System.out.println("3) Academic Staff");
      // create subject
      // assign subejct to lecturer
      int choice = scanner.nextInt();
      scanner.nextLine(); // Consume newline character

      switch (choice) {
        case 1:
          // Student student = new Student("Wan", 22);
          // student.registerSubjects();
          // student.dropSubjects();
          // break;
        case 2:
          Lecturer lecturer = new Lecturer("Harvin", 22);
          // lecturer.gradeStudent();
          break;
        case 3:
          handleAcademicStaff();
          break;
        default:
          System.out.println("Invalid choice.");
          break;
      }
      System.out.println("Do you want to continue? (Y/N)");
      String continueChoice = scanner.nextLine();
      if (continueChoice.equalsIgnoreCase("N")) {
        continuing = false;
      }
    }
    scanner.close();
  }

  // ***********Academic Staff***************//
  private static void handleAcademicStaff() {
    System.out.println("Good day: " + staff.getname());
    System.out.println("Select an action below");
    System.out.println("1) Add subject only");
    System.out.println("2) Add lecturer only");
    System.out.println("3) Add subject with lecturer");
    System.out.println("4) Change subject's lecturer");

    int aCChoice = scanner.nextInt();
    scanner.nextLine(); // Consume newline character

    switch (aCChoice) {
      case 1:
        addSubject();
        break;
      case 2:
        addLecturer();
        break;
      case 3:
        addSubjectWithLecturer();
        break;
      case 4:
        changeSubjectLecturer();
        break;
      default:
        System.out.println("Invalid input, please enter number 1, 2, 3, or 4");
        break;
    }
  }

  private static void addSubject() {
    System.out.println("Please enter Subject code :");
    String code = scanner.nextLine();
    System.out.println("Please enter Subject name :");
    String subName = scanner.nextLine();
    System.out.println("Please enter Subject credit hours :");
    String credit = scanner.nextLine();
    staff.createSubject(code, subName, credit);
  }

  private static void addLecturer() {
    System.out.println("Please enter lecturer name :");
    String lecName = scanner.nextLine();
    System.out.println("Please enter Lecturer ID :");
    int lecID = scanner.nextInt();
    scanner.nextLine(); // Consume newline character
    staff.registerlecList(lecName, lecID);
  }

  private static void addSubjectWithLecturer() {
    System.out.println("Please enter Subject code :");
    String code = scanner.nextLine();
    System.out.println("Please enter Subject name :");
    String subName = scanner.nextLine();
    System.out.println("Please enter Subject credit hours :");
    String credit = scanner.nextLine();
    System.out.println("Please enter Subject lecturer name :");
    String lecName = scanner.nextLine();
    System.out.println("Please enter Lecturer ID :");
    int lecID = scanner.nextInt();
    scanner.nextLine(); // Consume newline character
    staff.registerlecList(lecName, lecID);
    staff.createSubjectAndlecList(code, subName, credit, lecName, lecID);
  }

  private static void changeSubjectLecturer() {
    System.out.println("Please enter Subject code :");
    String code = scanner.nextLine();
    System.out.println("Please enter Subject lecturer name :");
    String lecName = scanner.nextLine();
    System.out.println("Please enter Lecturer ID :");
    int lecID = scanner.nextInt();
    scanner.nextLine(); // Consume newline character
    staff.changeSubLecturer(code, lecName, lecID);
  }
  // ***********Academic Staff END***************//
}
