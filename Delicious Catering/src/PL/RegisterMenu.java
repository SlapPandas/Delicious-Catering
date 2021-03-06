package PL;

import java.util.*;
import BLL.*;

public class RegisterMenu {
    Scanner stringInput = new Scanner(System.in);
    Client CV = new Client(); 

    public void runRegister(){  
        addtoClients();  
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
    public void addtoClients(){
        String username,password,fname,surname,contactnr,email,address;
        Boolean adminRights= false;
        System.out.println("Please enter your username");
        username = checkValidStringInput(stringInput.nextLine().trim());
        System.out.println("Please enter your password");
        password = checkValidStringInput(stringInput.nextLine().trim());
        System.out.println("Please enter your first name");
        fname = checkValidStringInput(stringInput.nextLine().trim());
        System.out.println("Please enter your surname");
        surname = checkValidStringInput(stringInput.nextLine().trim());
        System.out.println("Please enter your conact number");
        contactnr = checkValidStringInput(stringInput.nextLine().trim());
        System.out.println("Please enter your email address");
        email = checkValidStringInput(stringInput.nextLine().trim());
        System.out.println("please enter your address");
        address = checkValidStringInput(stringInput.nextLine().trim());
        CV.RegisterClient(username, password, fname, surname, contactnr, email, address, adminRights);
    }  
} 
