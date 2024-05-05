
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//This is the DATA LAYER:

class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}


//This is the BUSINESS LAYER:



class UserRegistrationService {
    private List<User> users;

    public UserRegistrationService(List<User> users) {
        this.users = users;
    }

    // Register a new user
    public boolean registerUser(String username, String password) {
        // Check if username already exists
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return false; // Username already exists
            }
        }

        // Add new user
        users.add(new User(username, password));
        return true; // User registered successfully
    }

    // Validate user credentials for login
    public boolean validateUser(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false; // Invalid credentials
    }
}


//This is the PRESENTATION LAYER:



public class UserRegistration{
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        UserRegistrationService registrationService = new UserRegistrationService(users);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Sign up");
            System.out.println("2. Log in");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    signUp(scanner, registrationService);
                    break;
                case 2:
                    login(scanner, registrationService);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void signUp(Scanner scanner, UserRegistrationService registrationService) {
        System.out.println("Enter username:");
        String username = scanner.nextLine();

        System.out.println("Enter password:");
        String password = scanner.nextLine();

        boolean isRegistered = registrationService.registerUser(username, password);
        if (isRegistered) {
            System.out.println("User registered successfully!");
        } else {
            System.out.println("Username already exists. Please choose a different one.");
        }
    }

    private static void login(Scanner scanner, UserRegistrationService registrationService) {
        System.out.println("Enter username:");
        String username = scanner.nextLine();
        
        System.out.println("Enter password:");
        String password = scanner.nextLine();

        boolean isValidUser = registrationService.validateUser(username, password);
        if (isValidUser) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid username or password. Please try again.");
        }
    }
}

