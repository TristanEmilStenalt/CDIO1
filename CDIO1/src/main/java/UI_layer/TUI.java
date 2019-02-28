package UI_layer;/*
Brugergrænseflade implementering/use-cases.
Hovedmenu:
1. Opret ny bruger
2. List Brugere
3. Ret bruger
4. Slet bruger
6. Afslut program
 */


import Data_layer.dal.IUserDAO;
import Data_layer.dto.UserDTO;
import Function_layer.FunkController;

import java.util.List;
import java.util.Scanner;

public class TUI {

    //fields
    Scanner scan = new Scanner(System.in);
    FunkController fCon = new FunkController();


    // Methods

    public void showMenu() throws IUserDAO.DALException {
        boolean menuActive = true;

        do {
            System.out.print("Press ENTER to continue...");
            scan.next();
            System.out.println("--- Main Menu ---\n(1) Create User\n(2) Show Users\n(3) Update User\n(4) Delete User\n(5) Exit\n--- Main Menu ---");
            int menu = scan.nextInt();

            switch (menu)
            {
                case 1:
                    createUser();
                    break;
                case 2:
                    showUsers();
                    break;
                case 3:
                    updateUser();
                    break;
                case 4:
                    deleteUser();
                    break;
                case 5:
                    menuActive = false;
                    break;

                default: break;
            }

        } while (menuActive == true);

        scan.close();
    }


    // Use Case methods

    public void createUser() throws IUserDAO.DALException {
        System.out.println("--- Enter details below. User ID and Password will be assigned automatically. ---");
        System.out.println("Enter username: ");
        String userName = scan.next();
        System.out.println("Enter initials (2-4 characters): ");
        String initials = scan.next();
        System.out.println("Enter cpr: ");
        int cpr = scan.nextInt();
        System.out.println("Enter roles: ");
        String roles = scan.next();

        pressToContinue();

        fCon.createUser(userName, initials, cpr, roles); // Calls FunkController and passes along params

        System.out.println("[User Created Sucessfully]");
    }

    public void showUsers()throws IUserDAO.DALException
    {
        List<UserDTO> userList = fCon.getUsers();
        for (UserDTO user : userList) {
            System.out.println(user);
        }
        pressToContinue();
    }

    public void updateUser() throws IUserDAO.DALException {
        System.out.println("Enter ID of user to update: ");
        int userID = scan.nextInt();

        System.out.println("Enter new username: ");
        String userName = scan.next();
        System.out.println("Enter new initials: ");
        String ini = scan.next();
        System.out.println("Enter new role: ");
        String roles = scan.next();
        fCon.updateUser(userID,userName,ini,roles);
    }

    public void deleteUser() throws IUserDAO.DALException
    {
        System.out.println("Select userID of the user you wish to delete: ");
        int deleteUser = scan.nextInt();
        fCon.deleteUser(deleteUser);
    }


    // Helping methods

    public void pressToContinue()
    {

    }




}
