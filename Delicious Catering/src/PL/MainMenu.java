package PL;

import java.util.*;

public class MainMenu {
    Scanner stringInput = new Scanner(System.in);
    private static void printHeading(){
        System.out.println("+------------------------------+");
        System.out.println("|           Welcome to         |");
        System.out.println("|        Delicious Catering    |");
        System.out.println("+------------------------------+");
        
    }

    private static void printMainMenu(){
        System.out.println("\nPlease make a selection:");
        System.out.println("1: Login");
        System.out.println("2: Register");
        System.out.println("0: Exit");
    }

    public void runMainMenu(){
        printHeading();   
        printMainMenu();
        mainMenuChoice();     
    }

    private int getInput(){
        
        int choice = -1;
        Boolean validInput = false;      
        String sChoice;  
        while(validInput == false){
            sChoice = checkValidStringInput(stringInput.nextLine().trim());
            try{
                choice = Integer.parseInt(sChoice);                
                validInput = true;
            }
            catch(NumberFormatException e){
                System.out.println("Please enter a valid input");
                printMainMenu();
            }
        }
        return choice;
    }

    private void mainMenuChoice(){
        Boolean validInput = false;
        while(validInput == false){
            int choice = getInput();
            switch(choice){
                case 0:                    
                    validInput = true;                                    
                    break;
                case 1: 
                    LoginMenu.runLoginMenu();
                    break;
                case 2:
                    RegisterMenu.runRegister();
                    break;
                default: 
                    System.out.println("Invalid menu option. Please try again.");
                    printMainMenu();
                    break;
            }
        }
        stringInput.close();
        System.exit(0);    
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
