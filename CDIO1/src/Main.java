import SQL.JDBC;
import java.util.*;
public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        JDBC startSQL = new JDBC();
        String host;
        String username;
        String password;
        System.out.println("Would you like to use Tristans or Marks database? [1/2]");

        int startChoice = input.nextInt();

        switch (startChoice){
            case 1:
                break;
            case 2: host = "ec2-52-30-211-3.eu-west-1.compute.amazonaws.com";
                username = "s153679";
                password = "2IYMod6yoCtICi61cdPFR";
              //  startSQL.sqlCom(host,username,password);
        }
    }
}