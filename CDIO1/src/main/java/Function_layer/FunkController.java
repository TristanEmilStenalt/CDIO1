package Function_layer;

import Data_layer.dal.IUserDAO;
import Data_layer.dal.UserDAOimpl;
import Data_layer.dto.UserDTO;

public class FunkController {

    // fields
    IUserDAO idao = new UserDAOimpl();
    //ourGenerator gen = new ourGenerator(); // ment til at indeholde funktionalitet der generere unikke ID og Pass.

    // Constructor

    // Methods
    public void createUser(String userName, String initials, int cpr, String roles) throws IUserDAO.DALException
    {
        UserDTO user = new UserDTO(); // Laver ny User, men dens attributter er tomme indtil videre.

        //user.setUserId(gen.genId()); // skal tildeles et entydigt/unikt UserID.
        user.setUserName(userName);
        user.setIni(initials);
        user.setCpr(cpr);
        //user.setPass(gen.genPassword()); // skal tildeles et tilfældigt genereret password, som overholder DTU's regler for kodeord.
        user.setRoles(roles);

        idao.createUser(user); // Sender UserDTO objektet videre ved kald af metode i dao'en, som så gemmer brugeren i databasen.
    }

    public void showUsers() throws IUserDAO.DALException
    {

    }

    public void updateUser(int id) throws IUserDAO.DALException
    {
        idao.getUser(id);
    }

    public void deleteUser() throws IUserDAO.DALException
    {

    }

}
