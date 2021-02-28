package PL;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;


public class ClientCreateBooking {
    private String ClientName;
    private String EventAddress;
    private String EventType;
    private Boolean Decoration;
    private String theme = "None";    
    private Date eventDate;
    private int adultsAttending;
    private int childrenAttending;

    public void createNewBooking(){
        clearScreen();
        System.out.println("You are now making a new booking.");
        System.out.println("Please input the correct information.");
        System.out.println("Please enter your name");
        ClientName = getClientName(getStringInput());
        System.out.println("Please enter the address of the event");
        EventAddress = getEventAddress(getStringInput());
        System.out.println("Please enter the type of event (eg. Wedding, Birthday");
        EventType = getEventType(getStringInput());
        System.out.println("Would you like us to provide decoration?");
        System.out.println("Please enter Yes or No");
        Decoration = getDecorationTF(getStringInput());
        System.out.println("Please enter the date of the event (format dd-MM-yyyy)");
        eventDate = getBookingDate();
        System.out.println("How many Adults will be attending?");
        adultsAttending = getAdultsAttending(getStringInput());
        System.out.println("How many children will be attending?");
        childrenAttending = getChildrenAttending(getStringInput());
// take in food list and display
        System.out.println("Please select 1 Starter.");
        // read user input        
// take in food list and display
        System.out.println("Please select 1 Main.");
        // read user input
// take in food list and display
        System.out.println("Please select 1 Desert.");
        // read user input
// take in drinks list and display
        System.out.println("Please select 3 drinks you would like. (Format eg. 2,5,1)");
        // read user input
        System.out.println("Please enter any special requests, press 0 to finish.");
        // read user. repeat until 0 is pressed
// take in addons list and display
        System.out.println("Please select the add-ons you would like.");
        // read addOns
        System.out.println("Would you like to make use of Covid-19 equipment?");
        System.out.println("Please enter Yes or No");
        // read if client wants covid equipment - Boolean

        // display information collected, allow user to confirm and then send to DAL.
    }

    private String getClientName(String input){
        String temp;
        temp = input;
        while(!verifyNormalString(temp)){
            System.out.println("Please enter a valid name.");
            temp = getStringInput();
        }
        return temp.trim();
    }

    private String getEventAddress(String input){
        String temp;
        temp = input;        
        return temp.trim();
    }

    private String getEventType(String input){
        String temp;
        temp = input;
        while(!verifyNormalString(temp)){
            System.out.println("Please enter a valid event type.");
            temp = getStringInput();
        }
        return temp.trim();
    }

    private Boolean getDecorationTF (String input){
        String temp;
        Boolean validInput = false;
        temp = input.toUpperCase();
        while(!verifyNormalString(temp)){
            System.out.println("Please enter a valid input.");
            temp = getStringInput();
        }
        while(!validInput){
            if (temp.matches("YES") || temp.matches("NO")) {
                validInput = true;                
            }
            else
            {
                validInput = false;
            }
        }
        if(temp.matches("YES")){
            theme = getDecorationTheme(getStringInput());
            return true;
        }
        else
        return false;
    }

    private String getDecorationTheme(String input){
        System.out.println("Please enter the theme you would like");
        String temp;
        temp = input;
        while(!verifyNormalString(temp)){
            System.out.println("Please enter a valid theme type. (do not inclued numbers)");
            temp = getStringInput();
        }
        return temp.trim();
    }

    private Date getBookingDate(){
        Boolean validDate = false;
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Date tempDate = null;
        df.setLenient(false);

        while(!validDate){
            try{
                System.out.println("Please enter a valid date, using format dd-MM-yyyy");
                tempDate = df.parse(getStringInput());
                validDate = true;
            }
            catch(Exception e){
                validDate = false;
            }            
        }
        return tempDate;        
    }

    private int getAdultsAttending(String input){
        String temp = input;
        int numAdults;
        while(!verifyInt(temp)){
            System.out.println("Please enter a valid input");
            temp = getStringInput();
        }
        numAdults = Integer.parseInt(temp);
        return numAdults;
    }

    private int getChildrenAttending(String input){
        String temp = input;
        int numChildren;
        while(!verifyInt(temp)){
            System.out.println("Please enter a valid input");
            temp = getStringInput();
        }
        numChildren = Integer.parseInt(temp);
        return numChildren;
    }
    
    private static void clearScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private String getStringInput(){
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

    private boolean verifyInt(String input){
        int temp;
        try{
            temp = Integer.parseInt(input);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    private boolean verifyNormalString(String normalInput){
        normalInput = normalInput.trim();

        if(normalInput == null || normalInput.equals(""))
            return false;

        if(!normalInput.matches("[a-zA-Z]*"))
            return false;

        return true;        
    }
}
