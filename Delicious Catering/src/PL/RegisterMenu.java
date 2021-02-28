package PL;

import java.util.*;

public class RegisterMenu {

    public static void runRegister(){
        
    }

    private String getStringInput() {
        Scanner stringInputs = new Scanner(System.in);
        String temp = "";
        Boolean valid = false; 
        while(valid = false){
            try {
                temp = stringInputs.nextLine();
                valid = true;
            } catch (Exception e) {
                System.out.println("Please enter a valid input.");
            }
        }
        return temp;
    }
    
    private boolean verifyNormalString(String normalInput){
        normalInput = normalInput.trim();
    
        if(normalInput == null || normalInput.equals(""))
            return false;
    
        if(!normalInput.matches("[a-zA-Z]*"))
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