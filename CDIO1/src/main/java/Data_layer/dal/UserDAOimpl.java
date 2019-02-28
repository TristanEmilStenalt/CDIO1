package Data_layer.dal;

import Data_layer.dto.UserDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOimpl implements IUserDAO {
    String host = "ec2-52-30-211-3.eu-west-1.compute.amazonaws.com";
    String username = "s173839";
    String password = "uOkOJknRbHNXZMTPuBV9q";

    private Connection createConnection() throws DALException {
        try {
            return DriverManager.getConnection("jdbc:mysql://"+host+"/"+username+"?"
                    + "user="+username+"&"+"password="+password);
        } catch (SQLException e) {
            throw new DALException(e.getMessage());
        }
    }


    @Override
    public UserDTO getUser(int userId) throws DALException {

        try (Connection c = createConnection())
        {

            Statement statement = c.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM usersDB WHERE userId = " + userId);
            //hasNext() behøvet
            resultSet.next();



            String userName = resultSet.getString(2);
            String ini = resultSet.getString(3);
            int cpr = resultSet.getInt(4);
            String pass = resultSet.getString(5);
            //List<String> roles = resultSet.getString(6);

            //UserDTO user = new UserDTO(userId,userName,ini,cpr,pass,roles);

            c.close();

            //return user;

        } catch (SQLException e) {
            throw new DALException(e.getMessage());
        }


        return null;
    }

    @Override
    public List<UserDTO> getUserList() throws DALException {
        List<UserDTO> users = new ArrayList<>();
        //Pseudo: for hver bruger i databasen lav put bruger i databasen

        return users;
    }

    @Override
    public void createUser(UserDTO user) throws DALException {

    }

    @Override
    public void updateUser(UserDTO user) throws DALException {
//loadDriver(); //Obsolete - only needed in rare cases.
        //try with resources (Java 7) - automatically calls connection.close() on end of try-catch block
        //Ensures that connections aren't left hanging
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://"+host+"/"+username+"?"
                + "user="+username+"&"+"password="+password)){
            Statement statement = connection.createStatement();
            // Create sql statement for inserting new user into the database.
            statement.executeUpdate(sql);
            showAllUsers();
            return;
        } catch (SQLException e) {
            //Remember to handle Exceptions gracefully! Connection might be Lost....
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUser(int userId) throws DALException {

    }
}
