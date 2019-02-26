package dal;

import dto.UserDTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAOimpl implements IUserDAO {

    private Connection createConnection() throws DALException {
        try {
            return DriverManager.getConnection("jdbc:mysql://ec2-52-30-211-3.eu-west-1.compute.amazonaws.com/s173839?"
                    + "user=s173839&password=uOkOJknRbHNXZMTPuBV9q");
        } catch (SQLException e) {
            throw new DALException(e.getMessage());
        }
    }


    @Override
    public UserDTO getUser(int userId) throws DALException {



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

    }

    @Override
    public void deleteUser(int userId) throws DALException {

    }
}
