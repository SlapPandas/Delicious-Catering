package PL;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import BLL.AddOn;
import BLL.Beverage;
import BLL.Food;
import BLL.Order;

public class ClientCreateBooking {
    // variables needed to run user input and display lists
    Scanner stringInput = new Scanner(System.in);
    Food FV = new Food();
    Beverage BV = new Beverage();
    AddOn AOV = new AddOn();
    Order OV = new Order();
    // variables needed to store user input
    private String ClientName;
    private String EventAddress;
    private String EventType;
    private Boolean Decoration;
    private String theme = "none";    
    private Date eventDate;
    private int adultsAttending;
    private int childrenAttending;
    private String starterChosen;
    private String mainChosen;
    private String desertChosen;
    private List<String> chosenFood;
    private List<String> chosenDrinks;
    private List<String> specialRequests;
    private List<String> addOns;
    private Boolean covidEquipment;
    
    public void createNewBooking() throws ParseException{
        chosenDrinks.clear();
        chosenFood.clear();
        specialRequests.clear();
        addOns.clear();
        theme = "none";
        Decoration = false;
        covidEquipment = false;        
        clearScreen();    
        getClientName();        
        getEventAddress();        
        getEventType();        
        getDecorationTF();
        getBookingDate();        
        getAdultsAttending();        
        getChildrenAttending();
        clearScreen();          
        getStarterChoice();  
        clearScreen();
        getMainChoice();   
        clearScreen();
        getDesertChoice();      
        clearScreen();
        getDrinksChoice();
        clearScreen();        
        getSpecialFoodRequest();    
        clearScreen(); 
        getAdOnList();   
        clearScreen();
        getCovidTF();
        clearScreen();
        displayEnteredInfo();
        checkValidOrder(); 
        stringInput.close();
    }

    private void getClientName(){
        System.out.println("You are now making a new booking.");
        System.out.println("Please input the correct information.");
        System.out.println("Please enter your name"); 
        ClientName = checkValidStringInput(stringInput.nextLine().trim());         
    }

    private void getEventAddress(){
        System.out.println("Please enter the address of the event");
        EventAddress = checkValidStringInput(stringInput.nextLine().trim());
    }

    private void getEventType(){
        System.out.println("Please enter the type of event (eg. Wedding, Birthday)");
        EventType = checkValidStringInput(stringInput.nextLine().trim());

    }

    private void getDecorationTF (){
        System.out.println("Would you like us to provide decoration?");
        Decoration = checkValidTF();
        if (Decoration) {
            getDecorationTheme();
        }
    }

    private Boolean checkValidTF(){
        System.out.println("Please enter Yes or No");
        String input;
        Boolean validInput = false;
        Boolean localCheck = false;
        while (validInput == false) {
            input = stringInput.nextLine().trim().toLowerCase();
            switch (input) {
                case "YES": 
                    localCheck = true;
                    break;
                case "NO":
                    localCheck = false;
                    break;
                default:
                    System.out.println("Invalid input, please enter yes or no.");
                    break;
            }
        }
        return localCheck;
    }

    private void getDecorationTheme(){
        System.out.println("Please enter the theme you would like");
        theme = checkValidStringInput(stringInput.nextLine().trim());
    }

    private void getBookingDate(){
        System.out.println("Please enter the date of the event (dd-MM-yyyy)");
        Boolean validDate = false;
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Date tempDate = null;
        df.setLenient(false);
        String input = stringInput.nextLine();
        while(validDate == false){
            input = checkValidStringInput(stringInput.nextLine().trim());
            try{                
                tempDate = df.parse(input);
                eventDate = tempDate;
                validDate = true;
            }
            catch(Exception e){
                System.out.println("Please enter a valid date, using format dd-MM-yyyy");
                input = checkValidStringInput(stringInput.nextLine().trim());
            }            
        }                
    }

    private void getAdultsAttending(){
        System.out.println("How many Adults will be attending?");
        adultsAttending = checkValidIntInput(stringInput.nextLine().trim());
    }

    private void getChildrenAttending(){
        System.out.println("How many children will be attending?");
        childrenAttending = checkValidIntInput(stringInput.nextLine().trim());
    }
    
    private int checkValidIntInput(String input){
        Boolean validInput = false;
        int output = 0;
        while (validInput == false) {
            if(input ==null || input.matches("")){
                System.out.println("Please enter a valid input");
                input = stringInput.nextLine().trim();
                input = input.trim(); 
            }
            else
            {
                try {
                    output = Integer.parseInt(input);
                    validInput = true;                    
                } catch (Exception e) {
                    System.out.println("Please enter a valid number");
                    input = stringInput.nextLine().trim();
                }
            }
        }
        return output;
    }

    private void getCovidTF(){
        System.out.println("Would you like to make use of Covid-19 equipment?");
        covidEquipment = checkValidTF();
    }
    
    private void getCourseFoods(String MealType){
        List<Food> FoodList = FV.GetFood(MealType);
        for(int i = 0; i < FoodList.size() ; i++)
        {   
            System.out.println(FoodList.get(i).getFoodName() + " R" + FoodList.get(i).getFoodPrice());
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

    private  void getStarterChoice(){
        System.out.println("Please select 1 Starter.");
        getCourseFoods("Starter"); 
        Boolean fromList = false;
        String input; 
        while (fromList == false) { 
            input = checkValidStringInput(stringInput.nextLine().trim());   
            fromList = FV.CheckFoodExists(input);    
            if (fromList == false) {
                System.out.println("Please enter a valid starter choice");           
            } else{
                chosenFood.add(input);
                starterChosen = input;
            }                        
        }
    }

    private void getMainChoice(){
        System.out.println("Please select 1 Main.");
        getCourseFoods("Main"); 
        Boolean fromList = false;
        String input;
        while (fromList == false) { 
            input = checkValidStringInput(stringInput.nextLine().trim());
            fromList = FV.CheckFoodExists(input);
            if (fromList == false) {
                System.out.println("Please enter a valid main choice");
            } else{
                chosenFood.add(input);
                mainChosen = input;
            } 
        }    
    }

    private void getDesertChoice(){
        System.out.println("Please select 1 Desert.");
        getCourseFoods("Desert"); 
        Boolean fromList = false;
        String input;
        while (fromList == false) { 
            input = checkValidStringInput(stringInput.nextLine().trim());
            fromList = FV.CheckFoodExists(input);
            if (fromList == false) {
                System.out.println("Please enter a valid desert choice");
            } else{
                chosenFood.add(input);
                desertChosen = input;
            } 
        }
    }

    private void getDrinksChoice(){
        Boolean validChoice = false;                       
        System.out.println("How many different drinks would you like? (1, 2 or 3)");
        String input;
        while (validChoice == false) {
            input = checkValidStringInput(stringInput.nextLine().trim());
            if (input.matches("1")|| input.matches("2")|| input.matches("3")) {
                validChoice = true;
                displayDrinksList();
                int amountOfDrinks = Integer.parseInt(input);
                for (int i = 0; i < amountOfDrinks; i++) {
                    input = checkValidStringInput(stringInput.nextLine());
                    if (BV.CheckBeverageExists(input)) {
                        chosenDrinks.add(input);
                    } else {
                        System.out.println("Please enter a valid drink");
                        input = checkValidStringInput(stringInput.nextLine().trim());
                        i--;
                    }
                }
            } else {
                System.out.println("Please enter a valid drink amount");
            } 
        }                   
    }

    private void displayDrinksList(){
        List<Beverage> DrinkList = BV.GetBeverages();
        for(int i = 0; i < DrinkList.size(); i++)
        {
            System.out.println(DrinkList.get(i).getBeverageName() + " R" + DrinkList.get(i).getBeveragePrice());
        }
    }

    private void getSpecialFoodRequest(){
        System.out.println("Please enter any special requests.");
        Boolean exitInput = false;       
        String input;
        while (exitInput == false) {
            System.out.println("Press 0 to exit");
            input = checkValidStringInput(stringInput.nextLine().trim());
            if (input.matches("0")) {
                exitInput = true;
            } else {
                specialRequests.add(input);
            }
        }
    }

    private void getAdOnList(){
        System.out.println("Please right the name of the add ons you would like.");
        Boolean exitInput = false;
        Boolean fromList = false;
        String input;

        while (exitInput == false) {
            displayAddOnList();
            System.out.println("enter 0 if you would like to exit.");
            input = checkValidStringInput(stringInput.nextLine().trim());
            if (input.matches("0")) {
                exitInput = true;
            } else {
                while (fromList == false) {
                    fromList = AOV.CheckAddOnsExists(input);
                    if (fromList == false) {
                        System.out.println("Please enter a addon from the list");
                    } else {
                        addOns.add(input);
                        fromList = false;
                    }
                }
            }

        }
    }

    private void displayAddOnList(){
        List<AddOn> AddOnList = AOV.GetAddOn();
        for (int g = 0; g < AddOnList.size(); g++) {
            System.out.println(AddOnList.get(g).getAddOnName() + " R" + AddOnList.get(g).getAddOnPrice());
        }
    }

    private static void clearScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private void displayEnteredInfo(){
        System.out.println("Please confirm this is your order:");
        System.out.println("Your name is: " + ClientName + ", the " + EventType + " will be on: " + eventDate.toString() + " at: "+ EventAddress);
        if (Decoration) {
            System.out.println("You do want decoration, and you want the theme to be: " + theme);
        } else {
            System.out.println("You do not want decoration, ");            
        }
        System.out.println("There will be: " + Integer.toString(adultsAttending) + " adults addending and " + Integer.toString(childrenAttending) + "children attending");        
        System.out.println("The food you have chosen to eat is: " + starterChosen + ", " + mainChosen + ", " +  desertChosen);        
        System.out.println("The drinks you have selected are: ");
        for (int i = 0; i < chosenDrinks.size(); i++) {
            System.out.println(chosenDrinks.get(i).toString());
        }
        System.out.println("The addons you have chosen are:"); 
        for (int k = 0; k < addOns.size(); k++) {
            System.out.println(addOns.get(k).toString());
        }
        System.out.print("And you have ");
        if (covidEquipment) {
            System.out.println("chosen to use covid equipment");
            
        } else {
            System.out.println("not chosen to use covid equipment");
        }
    }

    private void checkValidOrder() throws ParseException {
        System.out.println("Is your order correct?"); 
         Boolean correctOrder = checkValidTF();
        if (correctOrder) {
            System.out.println("Order has been added.");
            int ordernumber = OV.GetOrderInfo(ClientName, EventAddress, EventType, Decoration,  theme, eventDate, chosenFood, chosenDrinks, specialRequests, addOns, covidEquipment, childrenAttending, adultsAttending);     
            System.out.println("Your order number is: " + ordernumber);
            System.out.println("Please remember this order number");                                
        } else {
            System.out.println("order has been erased.");
        }
    }
}
