import java.util.Scanner;

public class TUI {

    //fields
    Scanner scan = new Scanner(System.in);


    public void showMenu()
    {
        boolean menuActive = true;
        do {
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

    public void createUser()
    {

    }

    public void showUsers()
    {

    }

    public void updateUser()
    {

    }

    public void deleteUser()
    {

    }




}
