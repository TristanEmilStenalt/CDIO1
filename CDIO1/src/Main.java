import SQL.JDBC;
import TUI.TUI;

import java.util.*;
public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        JDBC startSQL = new JDBC();
        String host = "ec2-52-30-211-3.eu-west-1.compute.amazonaws.com";
        String username;
        String password;

        int startChoice;

        /*chooses databaseasdf dasfasd f
        *
        *
        * */

        while(true) {
            System.out.println("Would you like to use Tristans, Marks or Keiths database? [1/3]");
             startChoice = input.nextInt();
            if(startChoice>3 || startChoice<1){
                System.out.println("Would you like to use Tristans, Marks or Keiths database? [1/3]");
                startChoice = input.nextInt();
            } else{
                 break;
            }
        }

        TUI tui = new TUI();


        switch (startChoice){
            case 1:
                username = "s173839";
                password = "uOkOJknRbHNXZMTPuBV9q";
                startSQL.setValues(host,username,password);
                tui.mainMenu();

                break;
            case 2:
                username = "s153679";
                password = "2IYMod6yoCtICi61cdPFR";
                startSQL.setValues(host,username,password);
                tui.mainMenu();

                break;

            case 3:
                username = "s173945";
                password = "m3q6pH6Tb4zGVfk4YImjr";
                startSQL.setValues(host,username,password);
                tui.mainMenu();

                break;
        }
    }
}