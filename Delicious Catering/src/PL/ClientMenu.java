package PL;

import BLL.*;
import java.text.ParseException;
import java.util.*;

public class ClientMenu {
    Scanner stringInput = new Scanner(System.in);
    Order OV = new Order();  
    ClientCreateBooking NB = new ClientCreateBooking();  
    public void runClientMenu(String username){
        Boolean exitInput = false;      
        while (exitInput == false) {
            clearScreen();
        printClientMenu();
        try {
            clientMenuChoice(clientMenuInput(), username);
        } catch (Exception e) {}
        }                
    }

    private void printClientMenu(){
        System.out.println("1: Make a booking");
        System.out.println("2: Cancel a booking");
        System.out.println("3: Pay for a booking");
        System.out.println("4: Back to main menu");
        System.out.println("0: exit");
    }

    private int clientMenuInput(){
        Scanner UI = new Scanner(System.in);
        int choice = -1;
        Boolean validInput = false;
        while(validInput == false){
            try{
                choice = Integer.parseInt(UI.nextLine());                
                validInput = true;
            }
            catch(NumberFormatException e){
                System.out.println("Please enter a valid input");
                printClientMenu();
                validInput = false;
            }
        }
        UI.close();
        return choice;
    }

    private void clientMenuChoice(int choice, String username) throws ParseException{
        Boolean validInput = false;
        while(validInput == false){
            switch(choice){
                case 0:
                    System.exit(0);                                    
                    break;
                case 1:                     
                    NB.createNewBooking();                    
                    break;
                case 2:                
                    cancelBooking(username);                    
                    break;
                case 3:
                    payBooking(username);                    
                    break;
                case 4:
                    validInput = true;
                    break;
                default: 
                    System.out.println("Invalid menu option. Please try again.");
                    printClientMenu();
                    break;
            }
        }    
    }

    private void cancelBooking(String username) throws ParseException{
        System.out.println("Please enter your order number");
        String ordernrInput;
        Boolean validNumber = false;
        int ordernr = 0;
        while (validNumber == false) {
            ordernrInput = stringInput.nextLine().trim();
            try {
                ordernr = Integer.parseInt(ordernrInput);
                validNumber = true;
            } catch (Exception e) {
                System.out.println("Invalid input, please try again");
            }
        }
        OV.Cancellation(ordernr, username);
    }

    private void payBooking(String username){
        int ordernr = 0;
        Boolean validInput = false;
        String ordernrInput;
        
        while (validInput == false) {            
            System.out.println("Please enter your order number");
            ordernrInput = stringInput.nextLine().trim();
            try {
                ordernr = Integer.parseInt(ordernrInput);
            } catch (Exception e) {
                System.out.println("Please enter a valid input");
            }
        }
        try {
            OV.CheckDeposit(ordernr, username);
        } catch (Exception e) {
            System.out.println("unexpected error");
        }        
    }
    private static void clearScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
