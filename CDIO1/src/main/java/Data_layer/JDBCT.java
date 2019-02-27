package Data_layer;
import java.sql.*;

public class JDBCT {

        public void sqlCom(String host,String username, String password) {

            //loadDriver(); //Obsolete - only needed in rare cases.
            //try with resources (Java 7) - automatically calls connection.close() on end of try-catch block
            //Ensures that connections aren't left hanging

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://"+host+"/"+username+"?"
                + "user="+username+"&"+"password="+password)){
            Statement statement = connection.createStatement();
            System.out.println("Got resultset from database:");

            ResultSet rs = statement.executeQuery("SELECT * FROM usersDB WHERE userID=1996");
            rs.next();
            for(int i = 1; i<=6;i++) {
                System.out.printf(rs.getString(i)+" | ");
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

