import dal.IUserDAO;
import dal.UserDAOimpl;

public class FunkController {

    // fields
    IUserDAO dao = new UserDAOimpl();

    // Constructor

    // Methods
    public void createUser()
    {

    }

    public void showUsers()
    {

    }

    public void updateUser(int id) throws IUserDAO.DALException {
        dao.getUser(id);
    }

    public void deleteUser()
    {

    }
}