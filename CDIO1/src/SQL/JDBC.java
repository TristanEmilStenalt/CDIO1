package SQL;
import java.sql.*;

public class JDBC {

        public void  sqlCom(String host,String username, String password) {

            //loadDriver(); //Obsolete - only needed in rare cases.
            //try with resources (Java 7) - automatically calls connection.close() on end of try-catch block
            //Ensures that connections aren't left hanging

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://"+host+"/"+username+"?"
                + "user="+username+"&"+"password="+password)){

            /* try (Connection connection = DriverManager.getConnection("jdbc:mysql://ec2-52-30-211-3.eu-west-1.compute.amazonaws.com/s153679?"
                    + "user=s153679&password=2IYMod6yoCtICi61cdPFR")){

                    */
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM usersDB");
                System.out.println("Got resultset from database:");
                while (resultSet.next()){
                    System.out.println(resultSet.getString(1) + ": " + resultSet.getString(2));
                }
            } catch (SQLException e) {
                //Remember to handle Exceptions gracefully! Connection might be Lost....
                e.printStackTrace();
            }

        }

        /**
         * Old School and should be obsolete - Use only if there is a complaint about the driver missing...
         */
        @Deprecated
        private static void loadDriver() {

            try {
                Class.forName("com.mysql.cj.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }


    }

