import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Login login = new Login();

        System.out.println("=== User Registration ===");

        System.out.print("Enter a username (must contain an underscore, max 5 characters): ");
        String username = scanner.nextLine();

        System.out.print("Enter a password (min 8 characters, capital letter, number, special character): ");
        String password = scanner.nextLine();

        System.out.print("Enter your cell phone number (e.g. +27831234567): ");
        String cellPhoneNumber = scanner.nextLine();

        System.out.print("Enter your first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter your last name: ");
        String lastName = scanner.nextLine();

        String registrationMessage = login.registerUser(username, password, cellPhoneNumber, firstName, lastName);
        System.out.println(registrationMessage);

        System.out.println();
        System.out.println("=== Login ===");

        System.out.print("Enter your username: ");
        String loginUsername = scanner.nextLine();

        System.out.print("Enter your password: ");
        String loginPassword = scanner.nextLine();

        boolean loginSuccessful = login.loginUser(loginUsername, loginPassword);
        String loginStatusMessage = login.returnLoginStatus(loginSuccessful);
        System.out.println(loginStatusMessage);

        scanner.close();
    }
}
