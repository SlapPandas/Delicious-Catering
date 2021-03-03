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

        // display information collected, allow user to confirm and then send to DAL.
        // pass order info using getorderinfo
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
        int output = 0;
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
        adultsAttending = output; 
    }

    private void getChildrenAttending(){
        System.out.println("How many children will be attending?");
        String input;
        int output=0;
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
            {                
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
        childrenAttending = output;
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
//bll
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
                    starterChosen = input;
                    chosenFood.add(input);
                }
            }
            if (fromList == false) {
                System.out.println("Please enter a valid food choice");
                input = stringInput.nextLine();
                input = input.trim();
                validInput = false;
            }
        }
    }
//bll
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
                    chosenFood.add(input);
                    mainChosen = input;
                }
            }
            if (fromList == false) {
                System.out.println("Please enter a valid food choice");
                input = stringInput.nextLine();
                input = input.trim();
                validInput = false;
            }
        }    
    }
// bLL
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
                    desertChosen = input;
                    chosenFood.add(input);
                }
            }
            if (fromList == false) {
                System.out.println("Please enter a valid food choice");
                input = stringInput.nextLine();
                input = input.trim();
                validInput = false;
            }
        }
    }
// needs to gho to BLL
    private void getDrinksChoice(){
        
        Boolean validChoice = false;
        Boolean validInput = false;
        String check;
        List<Beverage> beverageList = BV.GetBeverages();

        System.out.println("How many different drinks would you like? (1, 2 or 3)");
        String input = stringInput.nextLine();
        input = input.trim();

        while (validInput == false && (input.matches("1")|| input.matches("2")|| input.matches("3"))){
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
        while (validChoice == false){
            for (int i = 0; i < Integer.parseInt(input); i++) {
                validInput = false;
                String userinputBeverage = stringInput.nextLine();
                validChoice = BV.CheckBeverageExists(userinputBeverage);
                if(validChoice){
                    chosenDrinks.add(userinputBeverage);
                    input = stringInput.nextLine();
                    input = input.trim();
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
                }
                else{
                    System.out.println("please enter a valid drink");
                    System.out.println();
                    displayDrinksList();
                    i--;
                    input = stringInput.nextLine();
                    input = input.trim();
                    while (validInput == false || input.matches("")){
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
                }
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
        Boolean validInput = false;        
        String input;
        while (exitInput == false) {
            System.out.println("Press 0 to exit");
            input = stringInput.nextLine();
            input = input.trim();
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
            switch (input) {
                case "0":
                    exitInput = true;
                    break;            
                default:
                    specialRequests.add(input);
                    validInput = false;
                    break;
            }
        }
    }
//bll
    private void getAdOnList(){
        System.out.println("Please right the name of the add ons you would like.");
        Boolean exitInput = false;
        Boolean validInput = false;
        String input;
        String check;
        List<AddOn> addOnsLocal = AOV.GetAddOn();
        while (exitInput == false) {
            displayAddOnList();
            System.out.println("enter 0 if you would like to exit.");
            input = stringInput.nextLine();
            input = input.trim();
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
            validInput = false;
            if (input.matches("0")) 
            {
                exitInput = true;
            } 
            else 
            {
                for (int k = 0; k < addOns.size(); k++) {
                    check = addOnsLocal.get(k).getAddOnName();
                    if (input.matches(check)) 
                    {
                        addOns.add(input);                   
                    }
                    else
                    {
                        System.out.println("Please enter an addon from the displayed list.");
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
        if (Decoration == false) {
            System.out.println("You do not want decoration, ");
        } else {
            System.out.println("You do want decoration, and you want the theme to be: " + theme);
        }
        System.out.println("There will be: " + Integer.toString(adultsAttending) + " adults addending and " + Integer.toString(childrenAttending) + "children attending");        
        System.out.println("The food you have chosen to eat is: " + starterChosen + ", " + mainChosen + ", " +  desertChosen);        
        System.out.println("The drinks you have selected are: ");
        for (int i = 0; i < chosenDrinks.size(); i++) {
            System.out.println(chosenDrinks.get(i).toString());
        }
        System.out.print("And you have ");
        if (covidEquipment == false) {
            System.out.println("not chosen to use covid equipment");
        } else {
            System.out.println("chosen to use covid equipment");
        }
    }

    private void checkValidOrder() throws ParseException {
        System.out.println("Is your order correct?");
        System.out.println("Please enter Yes or No");        
        String input;
        Boolean validInput = false;        
        while (validInput== false) {
            input = stringInput.nextLine();  
            input = input.trim();
            input = input.toUpperCase();
            switch (input) {
                case "YES": 
                    System.out.println("Order has been added.");
                    int ordernumber = OV.GetOrderInfo(ClientName, EventAddress, EventType, Decoration,  theme, eventDate, chosenFood, chosenDrinks, specialRequests, addOns, covidEquipment, childrenAttending, adultsAttending);     
                    System.out.println("Your order number is: " + ordernumber);            
                    validInput = true;
                    break;
                case "NO":
                    System.out.println("order has been erased.");
                    validInput = true;
                    break;
                default:
                    System.out.println("Please enter Yes or No");
                    break;
            }
        } 
    }

}
