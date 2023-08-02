package views ;
import java.util.Scanner;

public class GeneralView {

    public int displayMainMenu(Scanner scanner) {
        System.out.println("Login as:");
        System.out.println("1) Student");
        System.out.println("2) Lecturer");
        System.out.println("3) Academic Staff");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        return choice;
    }

    public void logoutMessage() {
        System.out.println("Logged out successfully.");
    }

    public void invalidMessage() {
        System.out.println("Invalid choice.");
    }

    public void lineBreak() {
        System.out.println("***********************************");
    }

    public void continueMessage() {
        System.out.println("Do you want to continue? (Y/N)");

    }

}
