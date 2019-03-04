package Data_layer.dal;

import Data_layer.dto.UserDTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserDAOimpl implements IUserDAO {

    // Local variables to make switch of database easier for the mind.
    String host = "ec2-52-30-211-3.eu-west-1.compute.amazonaws.com";
    String username = "s153679";
    String password = "2IYMod6yoCtICi61cdPFR";
    //String userTableName = "usersDBTest";

    // Creates connection to database
    private Connection createConnection() throws DALException {
        try {
            return DriverManager.getConnection("jdbc:mysql://"+host+"/"+username+"?"
                    + "user="+username+"&"+"password="+password);
        } catch (SQLException e) {
            throw new DALException(e.getMessage());
        }
    }



    //Returns user from database based on id input.
    @Override
    public UserDTO getUser(int userId) throws DALException {

        try (Connection c = createConnection())
        {
            Statement statement = c.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM usersDB WHERE userId = " + userId);

            resultSet.next();

            UserDTO user = new UserDTO();
            user.setUserId(resultSet.getInt(1));
            user.setUserName(resultSet.getString(2));
            user.setIni(resultSet.getString(3));
            user.setCpr(resultSet.getInt(4));
            user.setPass(resultSet.getString(5));

            String rolesStr = resultSet.getString(6);
            ArrayList<String> roles = new ArrayList<>(Arrays.asList(rolesStr.split(","))); //Splits the String into String elements at every "," in the String.
            user.setRoles(roles);

            c.close(); // close connection to db

            //return user;
            return user;

        } catch (SQLException e) {
            throw new DALException(e.getMessage());
        }
    }



    // Puts all users from the database in a list and returns the list
    @Override
    public List<UserDTO> getUserList() throws DALException {

        List<UserDTO> userList = new ArrayList<>(); // Declaration of new ArrayList of UserDTO type.

        try (Connection c = createConnection())
        {
            Statement statement = c.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM usersDB");
            System.out.println("Got resultset from database:");

            while (resultSet.next()){
                userList.add(getUser(resultSet.getInt(1)));
            }

            // c.close();

        } catch (SQLException e) {
            throw new DALException(e.getMessage());
        }
        return userList;
    }



    // Creates new user in database with user sent from controller
    @Override
    public void createUser(UserDTO user) throws DALException {
        try (Connection c = createConnection())
        {
            Statement statement = c.createStatement();

            // Puts all String Elements into a single String with "," as seperator.
            String roles = user.getRoles().toString(); // Ended up going with this way of doing it. toString method for ArrayList with Strings. Could have done something with loops etc.


            // Create sql statement for inserting new user into the database.
            statement.executeUpdate("INSERT INTO usersDB VALUES("+user.getUserId()+",'"+user.getUserName()+"','"+user.getIni()+"',"+user.getCpr()+",'"+user.getPass()+"','"+roles+"')");

            //c.close();
        }

        catch (SQLException e){
            e.printStackTrace();
            }
        }



        //Gets id counter value from database and ++ and returns it
    @Override
    public int idCount()throws DALException{
        int count=0;
        try (Connection c = createConnection())
        {
            Statement statement = c.createStatement();
            ResultSet result = statement.executeQuery("SELECT count FROM userAmount");

            while (result.next()){
                count = (result.getInt(1));
            }

            count++;
            statement.executeUpdate("UPDATE userAmount SET count="+count);
            //c.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
        }




        // Updates user in database with new userinfo sent from controller
    @Override
    public void updateUser(UserDTO user) throws DALException {
        try (Connection c = createConnection())
        {
            Statement statement = c.createStatement();
            statement.executeUpdate("UPDATE usersDB "+"SET userName='"+user.getUserName()+"' ,"+"ini='"+user.getIni()+"',"+"roles='"+user.getRoles()+"' WHERE userId="+user.getUserId());

            //c.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




    // Deletes user in database based on id gotten from controller
    @Override
    public void deleteUser(int userId) throws DALException {
        try (Connection c = createConnection()){

            Statement statement = c.createStatement();
            statement.executeUpdate("DELETE FROM usersDB WHERE userID="+userId);
            System.out.println("User has been deleted");

            //c.close();
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }





}
