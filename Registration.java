
 import java.util.Scanner;

public class Registration {


    static String username;
    static String password;
    static String cellNumber;
    static String firstName;
    static String lastName;
    static boolean isRegistered = false;

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        
        int choice;
        
        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            
            choice = input.nextInt();
            input.nextLine(); 
            
            switch(choice) {
                case 1:
                    System.out.print("Enter First Name: ");
                    firstName = input.nextLine();
                    System.out.print("Enter Last Name: ");
                    lastName = input.nextLine();
                    System.out.println(registerUser());
                    break;
                case 2:
                    System.out.println(returnLoginStatus());
                    break;
                case 3:
                    System.out.println("Goodbye");
                    break;
                default:
                    System.out.println("Invalid option, try again.");
            }
            
        } while (choice != 3);
    }

    // --- METHODS AS REQUIRED ---

    public static boolean checkUserName(String user) {
        // Condition: Contains underscore AND no more than 5 characters
        return user.contains("_") && user.length() <= 5;
    }

    public static boolean checkPasswordComplexity(String pass) {
        // Condition: At least 8 chars, 1 Capital, 1 Number, 1 Special character
        if (pass.length() < 8) return false;
        
        boolean hasCapital = false;
        boolean hasNumber = false;
        boolean hasSpecial = false;

        for (char c : pass.toCharArray()) {
            if (Character.isUpperCase(c)) hasCapital = true;
            if (Character.isDigit(c)) hasNumber = true;
            if (!Character.isLetterOrDigit(c)) hasSpecial = true;
        }

        return hasCapital && hasNumber && hasSpecial;
    }

    public static boolean checkCellPhoneNumber(String cell) {
        // Condition: Contains international code (+) and no more than 10 digits after
        return cell.startsWith("+") && cell.length() <= 12;
    }

    public static String registerUser() {
        
        String result = "";
        
        // Check Username
        while(true) {
            System.out.print("Enter Username: ");
            username = input.nextLine();
            if(checkUserName(username)) {
                result += "Username successfully captured.\n";
                break;
            } else {
                System.out.println("Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.");
            }
        }

        // Check Password
        while(true) {
            System.out.print("Enter Password: ");
            password = input.nextLine();
            if(checkPasswordComplexity(password)) {
                result += "Password successfully captured.\n";
                break;
            } else {
                System.out.println("Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.");
            }
        }

        // Check Cell Number
        while(true) {
            System.out.print("Enter Cell Number: ");
            cellNumber = input.nextLine();
            String cell = null;
            if(checkCellPhoneNumber(cell)) {
                result += "Cell phone number successfully added.\n";
                break;
            } else {
                System.out.println("Cell phone number is incorrectly formatted or does not contain international code; please correct the number and try again.");
            }
        }

        isRegistered = true;
        return result;
    }

    public static boolean loginUser() {
        System.out.print("Enter Username: ");
        String inputUser = input.nextLine();
        System.out.print("Enter Password: ");
        String inputPass = input.nextLine();

        return inputUser.equals(username) && inputPass.equals(password);
    }

    public static String returnLoginStatus() {
        if(loginUser()) {
            return "Welcome " + firstName + ", " + lastName + " it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
}