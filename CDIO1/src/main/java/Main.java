import UI_layer.TUI;
import Data_layer.IUserDAO;

public class Main {

    public static void main(String[] args) throws IUserDAO.DALException {
        TUI tui = new TUI();
        tui.showMenu();
    }


}
