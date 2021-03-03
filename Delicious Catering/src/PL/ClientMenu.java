package PL;

import java.text.ParseException;
import java.util.*;

import BLL.Order;


public class ClientMenu {
    Scanner stringInput = new Scanner(System.in);
    Order OV = new Order();
    public void runClientMenu(){        
        clearScreen();
        printClientMenu();
        clientMenuChoice(clientMenuInput());
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
        while(validInput = false){
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

    private void clientMenuChoice(int choice) throws ParseException{
        Boolean validInput = false;
        while(validInput = false){
            switch(choice){
                case 0:
                    System.exit(0);                                    
                    break;
                case 1: 
                    ClientCreateBooking NB = new ClientCreateBooking();
                    NB.createNewBooking();
                    
                    break;
                case 2:                
                    cancelBooking();
                    
                    break;
                case 3:
                    payBooking();
                    
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

    private void cancelBooking(){

    }

    private void payBooking(){
        int orderID;
        String username;
        Boolean validInput = false;
        String input;
        input = stringInput.nextLine();
        while(validInput == false){  
            System.out.println("Please enter your username:");
                    
            if(input == null|| input.matches("")){
                System.out.println("Please enter a valid input");
                input = stringInput.nextLine();
                input = input.trim();
            }
            else
                validInput = true;
        }   
        validInput = false;
        Boolean validID = false;
        while (validID == false) {
            while (validInput == false) {                
                System.out.println("Please enter your order ID");   
                input = stringInput.nextLine();
            if(input == null|| input.matches("")){
                System.out.println("Please enter a valid input");
                input = stringInput.nextLine();
                input = input.trim();
            }
            else
                validInput = true;
            }

        }
    }

    private static void clearScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
