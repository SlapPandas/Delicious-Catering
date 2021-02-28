package PL;

import java.util.*;

public class MainMenu {
    
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
        mainMenuChoice(getInput());     
    }

    private int getInput(){
        Scanner UI = new Scanner(System.in);
        int choice = -1;
        Boolean validInput = false;        
        while(validInput = false){
            try{
                choice = Integer.parseInt(UI.nextLine());                
                validInput = true;
            }
            catch(NumberFormatException e){
                System.out.println("Please enter a valid input");
                printMainMenu();
                validInput = false;
            }
        }
        UI.close();
        return choice;
    }

    private void mainMenuChoice(int choice){
        Boolean validInput = false;
        while(validInput = false){
            switch(choice){
                case 0:
                    validInput = true;  
                    System.exit(0);                                    
                    break;
                case 1: 
                    validInput = true;
                    break;
                case 2:
                    validInput = true;
                    break;
                default: 
                    System.out.println("Invalid menu option. Please try again.");
                    printMainMenu();
                    break;
            }
        }    
    }
}
