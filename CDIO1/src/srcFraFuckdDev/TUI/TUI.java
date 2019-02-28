package TUI;
import SQL.JDBC;
import dal.IUserDAO;
import Funktionalitet.PasswordGenerator;
import java.util.*;
public class TUI{

    Scanner input = new Scanner(System.in);
    JDBC runSQLSequence = new JDBC();

    public void mainMenu(){
        System.out.println("----------MAIN MENU----------");
        System.out.println("1) Create User               ");
        System.out.println("2) Show all Users            ");
        System.out.println("3) Update User               ");
        System.out.println("4) Delete User               ");
        int choice = input.nextInt();
        switch (choice){
            case 1: createUserMenu();
            break;
            case 2: showUsersMenu();
            break;
            case 3: updateUserMenu();
            break;
            case 4: deleteUserMenu();
            break;
        }
    }

    public void createUserMenu(){
        System.out.println("----------CREATE USER----------");
        System.out.println("Enter userID: ");
        int userID = input.nextInt();
        System.out.println("Enter username: ");
        String userName = input.next();
        System.out.println("Enter initials (3 letters): ");
        String ini = input.next();
        System.out.println("Enter cpr: ");
        int cpr = input.nextInt();
        System.out.println("Enter your role (Admin/User): ");
        String roles = input.next();
        System.out.println("...Generating password...");
        // Creating new password every time the method is called
        new PasswordGenerator();
        String password = PasswordGenerator.generatePassword();

        System.out.println("...Your password is: "+password);
        try {
            Thread.sleep(800); // In your case it would be: Thread.sleep(100);
        } catch (Exception e) {
            e.printStackTrace();
        }
        runSQLSequence.createUser(userID,userName,ini,cpr,password,roles);
        // Send user data to next layer, prepare to implement into sql table
        mainMenu();
    }
    public void showUsersMenu(){
        runSQLSequence.showAllUsers();
    }
    public void updateUserMenu(){

    }
    public void deleteUserMenu(){
        System.out.println("What user would you like to delete? Please input his/her ID: ");
        int deleteID = input.nextInt();
        runSQLSequence.deleteUser(deleteID);
        mainMenu();
    }






}
