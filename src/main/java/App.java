import Model.API.*;
import Model.Database.Database;
import Model.PandaScoreFacade;
import Model.PandaScoreFacadeImpl;
import View.ApplicationWindow;

/**
 * Runner class.
 */
public class App {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Insufficient Arguments!");
            System.exit(1);
        }

        String in = args[0];
        String out = args[1];

        InputState input = null;
        OutputState output = null;
        Database database = new Database();

        if (in.equals("online")) {
            input = new InputOnline();
        } else if (in.equals("offline")) {
            input = new InputOffline();
        } else {
            System.out.println("Invalid Input API Argument");
            System.exit(1);
        }

        if (out.equals("online")) {
            output = new OutputOnline();
        } else if (out.equals("offline")){
            output = new OutputOffline();
        } else {
            System.out.println("Invalid Output API Argument");
            System.exit(1);
        }

        PandaScoreFacade facade = new PandaScoreFacadeImpl(input, output, database);
        ApplicationWindow window = new ApplicationWindow(facade);
    }
}
