
 import java.util.Scanner;

public class Registration {

    // private varibles to store user data
    private String username;
    private String password;
    private String cellNumber;
    private String firstName;
    private String lastName;
    private boolean isRegistered = false;

   //Scanner object fot user input
 static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        
        int choice;
        
        // main menu Loop, keeps the program running
     do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            
            choice = input.nextInt();
            input.nextLine(); 
            
           // Switch to handle Menu options
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

     // Method to check username
    // Condition: Must contain an underscore and have less less than 5 characters
     public static boolean checkUserName(String user) {
        // Condition: Contains underscore AND no more than 5 characters
        return user.contains("_") && user.length() <= 5;
    }

      // Method  to check password strength
     // Conditions: 8 Char, 1 Capital, 1 Number and 1 Special character
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
     // Method to check the cellPhoneNumber
     // Conditions: Must start with +27 and no more than 10 digit after 
    public static boolean checkCellPhoneNumber(String cell) {
        // Condition: Contains international code (+27) and no more than 10 digits after
        return cell.startsWith("+27") && cell.length() <= 12;
    }
    // Method to handle the registration process
    public static String registerUser() {
        
        String result = "";
        
        // Get and validate Username
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

        // Get and validate Password
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

        // Get and validate CallPhoneNumber
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
    // Method to verify login details
    public static boolean loginUser() {
        System.out.print("Enter Username: ");
        String inputUser = input.nextLine();
        System.out.print("Enter Password: ");
        String inputPass = input.nextLine();

        return inputUser.equals(username) && inputPass.equals(password);
    }
     // Methhod to display login message
    public static String returnLoginStatus() {
        if(loginUser()) {
            return "Welcome " + firstName + ", " + lastName + " it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
}
