package PL;

import java.util.*;

public class ClientMenu {
    public void runClientMenu(){
        clearScreen();
        printClientMenu();
        clientMenuChoice(clientMenuInput());
    }

    private void printClientMenu(){
        System.out.println("1: Make a booking");
        System.out.println("2: Cancel a booking");
        System.out.println("3: Check up on booking");
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

    private void clientMenuChoice(int choice){
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
                    checkBooking();
                    
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

    private void checkBooking(){

    }

    private static void clearScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
