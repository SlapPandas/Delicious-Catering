package PL;

import java.util.*;

public class RegisterMenu {
    Scanner stringInput = new Scanner(System.in);
    public static void runRegister(){
        
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
    
    private boolean verifyNormalString(String normalInput){
        normalInput = normalInput.trim();
    
        if(normalInput == null || normalInput.equals(""))
            return false;
        return true;        
    }
    
    private boolean verifyEmail(String email){
        email = email.trim();
    
        if(email == null || email.equals(""))
            return false;
    
        if(!email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$"))
            return false;
    
        return true;
    }  

    private static void clearScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    } 
}