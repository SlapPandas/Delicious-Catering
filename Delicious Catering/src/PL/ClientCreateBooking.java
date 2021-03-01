package PL;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import BLL.AddOn;
import BLL.Beverage;
import BLL.Food;
import BLL.Order;
import jdk.nashorn.api.tree.WhileLoopTree;

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
    private String starterFood;
    private String mainFood;
    private String desertFood;
    private List<String> chosenFood;
    private List<String> chosenDrinks;

    private Boolean covidEquipment;
        // not finished variables
    private List<String> specialRequests;
    private List<String> addOns;
    


    public void createNewBooking(){
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
        // do i need to do availibility check?        
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

        System.out.println("Please enter any special requests, press 0 to finish.");
        getSpecialFoodRequest();
        // read user. repeat until 0 is pressed
        
        System.out.println("Please select the add-ons you would like.");
        // take in addons list and display
        // read addOns
        getCovidTF();

        // display information collected, allow user to confirm and then send to DAL.
        //OV.GetOrderInfo(ClientName, EventAddress, EventType, Decoration, theme, eventDate, chosenFood, chosenDrinks, specialRequests, addOns, covidEquipment, childrenAttending, adultsAttending);
        stringInput.close();
    }

    private void getClientName(){
        System.out.println("You are now making a new booking.");
        System.out.println("Please input the correct information.");
        System.out.println("Please enter your name");
        Boolean validInput = false;        
        String input;  
        input = stringInput.nextLine();
        input = input.trim();
        while(validInput == false){                        
            if(input == null|| input.matches("")){
                System.out.println("Please enter a valid name");
                input = stringInput.nextLine();
                input = input.trim();
            }
            else
                validInput = true;
        }    
        ClientName = input;         
    }

    private void getEventAddress(){
        System.out.println("Please enter the address of the event");
        String input;
        Boolean validInput = false;
        input = stringInput.nextLine(); 
        input = input.trim();   
        while(validInput == false){            
            if(input == null|| input.matches("")){
                System.out.println("Please enter a valid event address");
                input = stringInput.nextLine();
                input = input.trim();
            }
            else
                validInput = true;
        }   
        EventAddress = input;
    }

    private void getEventType(){
        System.out.println("Please enter the type of event (eg. Wedding, Birthday)");
        String input;
        Boolean validInput = false;
        input = stringInput.nextLine(); 
        input = input.trim();   
        while(validInput == false){            
            if(input ==null|| input.matches("")){                
                System.out.println("Please enter a valid event type");
                input = stringInput.nextLine();
                input = input.trim();
            }
            else
                validInput = true;
        }   
        EventType = input;

    }

    private void getDecorationTF (){
        System.out.println("Would you like us to provide decoration?");
        System.out.println("Please enter Yes or No");        
        String input;
        Boolean validInput = false;        
        while (validInput== false) {
            input = stringInput.nextLine();  
            input = input.trim();
            input = input.toUpperCase();
            switch (input) {
                case "YES": 
                    Decoration = true;                
                    getDecorationTheme();
                    validInput = true;               
                    break;
                case "NO":
                    Decoration = false;
                    validInput = true;
                    break;
                default:
                    System.out.println("Please enter Yes or No");
                    break;
            }
        }        
    }

    private void getDecorationTheme(){
        System.out.println("Please enter the theme you would like");
        String input;
        Boolean validInput = false;
        input = stringInput.nextLine();  
        input = input.trim();  
        while(validInput == false){            
            if(input ==null|| input.matches("")){
                input = stringInput.nextLine();
                input = input.trim();
                System.out.println("Please enter a valid input");
            }
            else
                validInput = true;
        }
        theme = input;
    }

    private void getBookingDate(){
        System.out.println("Please enter the date of the event (dd-MM-yyyy)");
        Boolean validDate = false;
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Date tempDate = null;
        df.setLenient(false);
        String input = stringInput.nextLine();
        input = input.trim();
        while(validDate == false){
            try{                
                tempDate = df.parse(input);
                validDate = true;
            }
            catch(Exception e){
                System.out.println("Please enter a valid date, using format dd-MM-yyyy");
                input = stringInput.nextLine();
                input = input.trim();
                validDate = false;
            }            
        }
        eventDate = tempDate;        
    }

    private void getAdultsAttending(){
        System.out.println("How many Adults will be attending?");
        String input;
        int output;
        Boolean validInput = false;
        input = stringInput.nextLine(); 
        input = input.trim();    
        while(validInput == false){            
            if(input ==null || input.matches("")){
                System.out.println("Please enter a valid input");
                input = stringInput.nextLine();
                input = input.trim(); 
            }
            else{
                try {
                    output = Integer.parseInt(input.trim());
                    validInput = true;
                } catch (Exception e) {
                    System.out.println("Please enter a valid input");
                    input = stringInput.nextLine();
                    input = input.trim(); 
                }                    
            }
        }
        adultsAttending = Integer.parseInt(input); 
    }

    private void getChildrenAttending(){
        System.out.println("How many children will be attending?");
        String input;
        int output;
        Boolean validInput = false;
        input = stringInput.nextLine();   
        input = input.trim(); 
        while(validInput == false){            
            if(input ==null || input.matches("")){
                System.out.println("Please enter a valid input");
                input = stringInput.nextLine();
                input = input.trim(); 
            }
            else
                try {
                    output = Integer.parseInt(input.trim());
                    validInput = true;
                } catch (Exception e) {
                    System.out.println("Please enter a valid input");
                    input = stringInput.nextLine();
                    input = input.trim(); 
                }
                
        }   
    }
    
    private void getCovidTF(){
        System.out.println("Would you like to make use of Covid-19 equipment?");
        System.out.println("Please enter Yes or No");     
        String input;
        Boolean validInput = false;        
        while (validInput== false) {
            input = stringInput.nextLine();  
            input = input.trim();
            input = input.toUpperCase();
            switch (input) {
                case "YES": 
                    covidEquipment = true;                
                    validInput = true;               
                    break;
                case "NO":
                    covidEquipment = false;
                    validInput = true;
                    break;
                default:
                    System.out.println("Please enter Yes or No");
                    break;
            }
        }
    }
    
    private void getCourseFoods(String MealType){
        List<Food> FoodList = FV.GetFood(MealType);
        for(int i = 0; i < FoodList.size() ; i++)
        {   
            System.out.println(FoodList.get(i).getFoodName() + " R" + FoodList.get(i).getFoodPrice());
        }
    }

    private  void getStarterChoice(){
        System.out.println("Please select 1 Starter.");
        getCourseFoods("Starter"); 

        Boolean validInput = false;
        Boolean fromList = false;
        List<Food> FoodList = FV.GetFood("Starter");
        String input = stringInput.nextLine();
        String check;    
        input = input.trim();
        while (fromList == false) { 
            while (validInput == false) {
                if(input == null|| input.matches("")){
                    System.out.println("Please enter a valid input");
                    input = stringInput.nextLine();
                    input = input.trim();
                }
                else
                {
                    validInput = true;
                }                    
            }
            for(int i = 0; i < FoodList.size(); i++){
                check = FoodList.get(i).getFoodName();
                if (input.matches(check)) {
                    fromList = true;
                }
            }
            if (fromList == false) {
                System.out.println("Please enter a valid food choice");
                input = stringInput.nextLine();
                input = input.trim();
                validInput = false;
            }
        }
        chosenFood.add(input);
    }

    private void getMainChoice(){
        System.out.println("Please select 1 Main.");
        getCourseFoods("Main"); 

        Boolean validInput = false;
        Boolean fromList = false;
        List<Food> FoodList = FV.GetFood("Main");
        String input = stringInput.nextLine();
        String check;    
        input = input.trim();
        while (fromList == false) { 
            while (validInput == false) {
                if(input == null|| input.matches("")){
                    System.out.println("Please enter a valid input");
                    input = stringInput.nextLine();
                    input = input.trim();
                }
                else
                {
                    validInput = true;
                }                    
            }
            for(int i = 0; i < FoodList.size(); i++){
                check = FoodList.get(i).getFoodName();
                if (input.matches(check)) {
                    fromList = true;
                }
            }
            if (fromList == false) {
                System.out.println("Please enter a valid food choice");
                input = stringInput.nextLine();
                input = input.trim();
                validInput = false;
            }
        }
    chosenFood.add(input);
    }

    private void getDesertChoice(){
        System.out.println("Please select 1 Desert.");
        getCourseFoods("Desert"); 

        Boolean validInput = false;
        Boolean fromList = false;
        List<Food> FoodList = FV.GetFood("Desert");
        String input = stringInput.nextLine();
        String check;    
        input = input.trim();
        while (fromList == false) { 
            while (validInput == false) {
                if(input == null|| input.matches("")){
                    System.out.println("Please enter a valid input");
                    input = stringInput.nextLine();
                    input = input.trim();
                }
                else
                {
                    validInput = true;
                }                    
            }
            for(int i = 0; i < FoodList.size(); i++){
                check = FoodList.get(i).getFoodName();
                if (input.matches(check)) {
                    fromList = true;
                }
            }
            if (fromList == false) {
                System.out.println("Please enter a valid food choice");
                input = stringInput.nextLine();
                input = input.trim();
                validInput = false;
            }
        }
        chosenFood.add(input);
    }

    private void getDrinksChoice(){
        System.out.println("How many different drinks would you like? (1, 2 or 3)");
        Boolean choicesMade = false;
        Boolean validInput = false;
        String input = stringInput.nextLine();
        String check;
        List<Beverage> beverageList = BV.GetBeverages();
        input = input.trim();
        while (choicesMade == false){
            while (validInput == false){
                if(input == null|| input.matches("")){
                    System.out.println("Please enter a valid input");
                    input = stringInput.nextLine();
                    input = input.trim();
                }
                else
                {
                    validInput = true;
                }                
            }
            switch (input) {
                case "1": 
                {  
                    displayDrinksList();
                    System.out.println("Please type the name of the drink you would like");  
                    validInput = false; 
                    while (validInput == false){
                        if(input == null|| input.matches("")){
                            System.out.println("Please enter a valid input");
                            input = stringInput.nextLine();
                            input = input.trim();
                        }
                        else
                        {
                            validInput = true;
                        }    
                    }
                    for (int i = 0; i < beverageList.size(); i++) {
                        check = beverageList.get(i).getBeverageName();
                        if (input.matches(check)) {
                            validInput = true;
                            choicesMade = true;
                            chosenDrinks.add(input);
                            chosenDrinks.add("none");
                            chosenDrinks.add("none");
                        }
                        if (validInput == false) {
                            System.out.println("Please enter a drink that is displayed");
                            input = stringInput.nextLine();
                            input.trim();
                            validInput = false;
                        }
                    }                                                  
                    break;
                }
                case "2":
                {
                displayDrinksList();
                    System.out.println("Please type the name of the 1st drink you would like");
                    for (int i = 0; i < 2; i++) {
                        validInput = false; 
                        while (validInput == false){
                            if(input == null|| input.matches("")){
                                System.out.println("Please enter a valid input");
                                input = stringInput.nextLine();
                                input = input.trim();
                            }
                            else
                            {
                                validInput = true;
                            }    
                        }
                        for (int k = 0; k < beverageList.size(); k++) {
                            check = beverageList.get(k).getBeverageName();
                            if (input.matches(check)) {
                                validInput = true;
                                choicesMade = true;
                                chosenDrinks.add(input);
                            }
                            if (validInput == false) {
                                System.out.println("Please enter a drink that is displayed");
                                input = stringInput.nextLine();
                                input.trim();
                                validInput = false;
                            }
                        }
                    } 
                    chosenDrinks.add("none");                    
                    break;
                }
                case "3":
                {
                    displayDrinksList();
                        System.out.println("Please type the name of the 1st drink you would like");
                        for (int i = 0; i < 3; i++) {
                            validInput = false; 
                            while (validInput == false){
                                if(input == null|| input.matches("")){
                                    System.out.println("Please enter a valid input");
                                    input = stringInput.nextLine();
                                    input = input.trim();
                                }
                                else
                                {
                                    validInput = true;
                                }    
                            }
                            for (int j = 0; j < beverageList.size(); j++) {
                                check = beverageList.get(j).getBeverageName();
                                if (input.matches(check)) {
                                    validInput = true;
                                    choicesMade = true;
                                    chosenDrinks.add(input);
                                }
                                if (validInput == false) {
                                    System.out.println("Please enter a drink that is displayed");
                                    input = stringInput.nextLine();
                                    input.trim();
                                    validInput = false;
                                }
                            }
                        }                   
                    break;
                }                           
                default:
                    validInput = false;                   
                    break;
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
        
    }

    private static void clearScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
