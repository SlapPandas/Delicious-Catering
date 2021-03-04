package PL;

public class LoginMenu {
    ClientMenu CM = new ClientMenu();
    public static void runLoginMenu(){
        ClientMenu CM = new ClientMenu();
        
        
        // login client = true
        String username = "Test";
        CM.runClientMenu(username);

        // login admin

    }
}
