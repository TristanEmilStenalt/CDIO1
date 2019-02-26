package SQL;
import java.sql.*;

public class JDBC {
    public static String host;
    public static String username;
    public static String password;
        // Set values used for accessing either database in the beginning. Return so that the user can use the TUI.
        public void setValues(String host,String username, String password) {
        this.host=host;
        this.username = username;
        this.password = password;
        return;
        }

        public void createUser(int userID1,String userName1,String ini1,int cpr1,char[] password1,String role1) {
            //loadDriver(); //Obsolete - only needed in rare cases.
            //try with resources (Java 7) - automatically calls connection.close() on end of try-catch block
            //Ensures that connections aren't left hanging
            try (Connection connection = DriverManager.getConnection("jdbc:mysql://"+host+"/"+username+"?"
                    + "user="+username+"&"+"password="+password)){
                Statement statement = connection.createStatement();
                statement.executeUpdate("INSERT INTO usersDB VALUES(userID1,userName1,ini1,cpr1,password1,role1);");
                showAllUsers();
                return;
            } catch (SQLException e) {
                //Remember to handle Exceptions gracefully! Connection might be Lost....
                e.printStackTrace();
            }

        }

        public void showAllUsers(){
            try (Connection connection = DriverManager.getConnection("jdbc:mysql://"+host+"/"+username+"?"
                    + "user="+username+"&"+"password="+password)){
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM usersDB");
                System.out.println("Got resultset from database:");
                while (resultSet.next()){
                    System.out.println("|"+resultSet.getString(1) + " | " + resultSet.getString(2)+" | "+resultSet.getString(3)+" | "+resultSet.getString(3)+" | "+
                            resultSet.getString(4)+" | "+resultSet.getString(5)+" | "+resultSet.getString(6)+"|");
                }
            } catch (SQLException e) {
                //Remember to handle Exceptions gracefully! Connection might be Lost....
                e.printStackTrace();
            }
            return;
        }

        public void deleteUser(int id){
            try (Connection connection = DriverManager.getConnection("jdbc:mysql://"+host+"/"+username+"?"
                    + "user="+username+"&"+"password="+password)){
                Statement statement = connection.createStatement();
                statement.executeUpdate("DELETE FROM usersDB WHERE userID="+id);
                System.out.println("User has been deleted");
                showAllUsers();
                return;
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

