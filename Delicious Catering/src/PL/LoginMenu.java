package PL;

import BLL.*;
import java.util.*;

public class LoginMenu {
    Scanner stringInput = new Scanner(System.in); 
    ClientMenu CM = new ClientMenu();
    AdminMenu AM = new AdminMenu();

    public void runLoginMenu(){
        ClientMenu CM = new ClientMenu();        
        Boolean validLogin = false, isAdmin = false;
        String username = "",password="";
        Client LC = new Client();

        while (!validLogin) {
            System.out.println("Please enter your username:");
            username = checkValidStringInput(stringInput.nextLine().trim());
            System.out.println("Please enter password:");
            password = checkValidStringInput(stringInput.nextLine().trim());
            validLogin = LC.SuccessfulLogin(username, password);
            if (!validLogin) {
                System.out.println("Please enter a valid username and password.");
            }
        }
        if (isAdmin) {
            AM.runAdminMenu();            
        } else {
            CM.runClientMenu(username);
        }                        
    }

    private String checkValidStringInput(String input){
        Boolean validInput = false;
        while(validInput == false){            
            if(input ==null|| input.matches("")){
                System.out.println("Please enter a valid input");
                input = stringInput.nextLine();
                input = input.trim();                
            }
            else
                validInput = true;                
        }
        return input;
    }
}
