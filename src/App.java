import java.util.Scanner;

public class App {
  public static void main(String[] args) throws Exception {
    boolean continuing = true;

    Scanner scanner = new Scanner(System.in);
    AcadStaff staff = new AcadStaff("En.Ali", "AC01");

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
          System.out.println("Good day: " + staff.getname());
          System.out.println("Select An action below");
          System.out.println("1) add subject only");
          System.out.println("2) add lecturer only");
          System.out.println("3) add subject with Lecturer");
          System.out.println("4) Change subject's lecturer");
          int aCChoice = scanner.nextInt();
          scanner.nextLine(); // Consume newline character
          if (aCChoice == 1) {
            System.out.println("Please enter Subject code :");
            String code = scanner.nextLine();
            System.out.println("Please enter Subject name :");
            String subName = scanner.nextLine();
            System.out.println("Please enter Subject credit hours :");
            String credit = scanner.nextLine();
            staff.createSubject(code, subName, credit);

          } else if (aCChoice == 2) {
            System.out.println("Please enter lecturer name :");
            String lecName = scanner.nextLine();
            System.out.println("Please enter Lecturer ID :");
            int lecID = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
            staff.registerlecList(lecName, lecID);
          } else if (aCChoice == 3) {
            System.out.println("Please enter Subject code :");
            String code = scanner.nextLine();
            System.out.println("Please enter Subject name :");
            String subName = scanner.nextLine();
            System.out.println("Please enter Subject credit hours :");
            String credit = scanner.nextLine();
            System.out.println("Please enter Subject lecturer name :");
            String lecName = scanner.nextLine();
            System.out.println("Please enter Lectuer ID :");
            int lecID = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
            staff.registerlecList(lecName, lecID);
            staff.createSubjectAndlecList(code, subName, credit, lecName, lecID);

          } else if (aCChoice == 4) {
            System.out.println("Please enter Subject code :");
            String code = scanner.nextLine();
            System.out.println("Please enter Subject lecturer name :");
            String lecName = scanner.nextLine();
            System.out.println("Please enter Lectuer ID :");
            int lecID = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
            staff.changeSubLecturer(code, lecName, lecID);

          } else {
            System.out.println("Invalid input, please enter number 1, 2, 3, 4");
          }

          // staff.createSubject();
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

  // Acad Staff Function List
  // public AcadStaff addSub(AcadStaff staff) {
  //   System.out.println("Please enter Subject code :");
  //   Scanner sc = new Scanner(System.in);
  //   String code = sc.nextLine();
  //   System.out.println("Please enter Subject name :");
  //   String subName = sc.nextLine();
  //   System.out.println("Please enter Subject credit hours :");
  //   String credit = sc.nextLine();
  //   staff.createSubject(code, subName, credit);

  //   sc.close();
  //   return staff;
  // }

}
