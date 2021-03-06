package PL;
import BLL.*;
import java.util.*;

public class AdminMenu {
    Scanner stringInput = new Scanner(System.in);
    AddOn AOV = new AddOn();
    Beverage BV = new Beverage();
    Client CV = new Client();
    Food FV = new Food();
    Order OV = new Order();
    String menuSelection;
    Boolean exitSelected = false;

    public void runAdminMenu() throws Exception{
        
        while (!exitSelected) {
            System.out.println("1) view all orders");
            System.out.println("2) view all clients");
            System.out.println("3) View the full menu");
            System.out.println("4) View all the drinks");
            System.out.println("5) View all addons");
            System.out.println("6) Next menu");
            System.out.println("0) Exit\n");
            menuSelection = checkValidStringInput(stringInput.nextLine().trim());
            switch (menuSelection) {
                case "1":
                    viewOrders();
                    break;
                case"2":
                    viewClients();
                    break;
                case"3":
                    viewFoods();
                    break;
                case"4":
                    viewDrinks();
                    break;
                case"5":
                    viewAddons();
                    break;
                case"6":
                    // adding items to the txt files
                    break;
                case"0":
                    exitSelected = true;
                    break;
                default:
                    System.out.println("Please enter a valid input\n");
                    break;
            }
        }
    }

    public void runExtraMenu() throws Exception{
        Boolean backSelected = false;
        while (!backSelected) {
            System.out.println("1) Add to Addons");
            System.out.println("2) add to beverages");
            System.out.println("3) add to clients");
            System.out.println("4) add to foods");
            System.out.println("5) add to orders");
            System.out.println("6) back");
            System.out.println("0) exit\n");
            menuSelection = checkValidStringInput(stringInput.nextLine().trim());
            switch (menuSelection) {
                case "1":
                    addtoAddons();
                    break;
                case"2":
                    addtoDrinks();
                    break;
                case"3":
                    addtoClients();
                    break;
                case"4":
                    addtoFood();
                    break;
                case"5":
                    ClientCreateBooking CCB = new ClientCreateBooking();
                    CCB.createNewBooking();
                    break;
                case"6":
                    backSelected = true;
                    break;
                case"0":
                    backSelected = true;
                    exitSelected = true;
                    break;
                default:
                    System.out.println("Please enter a valid input\n");
                    break;
            }
        }        
    }

    public void addtoAddons(){
        String name;
        Double price;
        System.out.println("Please enter the name of the addon");
        name = checkValidStringInput(stringInput.nextLine().trim());
        System.out.println("Please enter the price of the addon \n");
        price = checkValidDoubleInput(stringInput.nextLine().trim());
        AOV.AddNewAddOn(name, price);           
    }

    public void addtoDrinks() {
        String name;
        Double price;
        System.out.println("Please enter the name of the drink");
        name = checkValidStringInput(stringInput.nextLine().trim());
        System.out.println("Please enter the price of the drink \n");
        price = checkValidDoubleInput(stringInput.nextLine().trim());
        BV.AddNewBeverage(name, price);
    }

    public void addtoClients(){
        String username,password,fname,surname,contactnr,email,address,input;
        Boolean adminRights= false,validInput=false;
        System.out.println("Please enter your username");
        username = checkValidStringInput(stringInput.nextLine().trim());
        System.out.println("Please enter your password");
        password = checkValidStringInput(stringInput.nextLine().trim());
        System.out.println("Please enter your first name");
        fname = checkValidStringInput(stringInput.nextLine().trim());
        System.out.println("Please enter your surname");
        surname = checkValidStringInput(stringInput.nextLine().trim());
        System.out.println("Please enter your conact number");
        contactnr = checkValidStringInput(stringInput.nextLine().trim());
        System.out.println("Please enter your email address");
        email = checkValidStringInput(stringInput.nextLine().trim());
        System.out.println("please enter your address");
        address = checkValidStringInput(stringInput.nextLine().trim());
        System.out.println("Please enter you admin rights");
        System.out.println("Type Yes or No");
        while (!validInput) {
            input = checkValidStringInput(stringInput.nextLine().trim());
            switch (input) {
                case "Yes":
                    adminRights = true;
                    validInput = true;
                    break;            
                case "No":
                    adminRights = false;
                    validInput = true;
                    break;
                default:
                    System.out.println("Invalid input, please try again");
                    input = checkValidStringInput(stringInput.nextLine().trim());
                    break;
            }
        }
        CV.RegisterClient(username, password, fname, surname, contactnr, email, address, adminRights);
    }

    public void addtoFood(){
        String name,course;
        Double price;
        System.out.println("Please enter the first letter of the course (eg. S = starter)");
        course = checkValidStringInput(stringInput.nextLine().trim());
        System.out.println("Please enter the name of the drink");
        name = checkValidStringInput(stringInput.nextLine().trim());
        System.out.println("Please enter the price of the drink \n");
        price = checkValidDoubleInput(stringInput.nextLine().trim());
        FV.AddNewFood(course, name, price);
    }

    public double checkValidDoubleInput(String input){
        double output = 0;
        Boolean validDouble = false;
        while (!validDouble) {
            try {
                output = Double.parseDouble(input);
                validDouble = true;
            } catch (Exception e) {
                System.out.println("invalid input, try again");
                input = checkValidStringInput(stringInput.nextLine().trim());
            }
        }
        return output;
    }

    public void viewOrders()throws Exception{
        List<Order> OrderList = OV.GetAllOrders();
        List<String> FoodList;
        List<String> reqList;
        List<String> drinkList;
        List<String> addonList;

        for (int i = 0; i < OrderList.size(); i++) {
            System.out.println("Username: "+ OrderList.get(i).getUserName() + ", " + "Order number: "+ + OrderList.get(i).getOrdernr() + ", " +"Canceled: "+ OrderList.get(i).getCancellation() + ", "+"Event address: "+ OrderList.get(i).getEventAddress());
            System.out.println("Event type: "+ OrderList.get(i).getEventType() +", " +"Decoration: "+ OrderList.get(i).getDecoration() + ", Theme: "+ OrderList.get(i).getTheme() + ", Decoration cost: R" + OrderList.get(i).getDecoration_TotalCost());
            System.out.println("Event date: "+ OrderList.get(i).getEventDate());
            FoodList = OrderList.get(i).getFood();
            System.out.println("Food chosen:");
            for (int j = 0; j < FoodList.size(); j++) {
                System.out.println(FoodList.get(j));                
            } 
            System.out.println("Total food cost for adults: R" + OrderList.get(i).getAdultFood_TotalCost());
            System.out.println("Total food cost for children: R" + OrderList.get(i).getChildFood_TotalCost());           
            reqList = OrderList.get(i).getSpecialFoodRequest();
            System.out.println("Special requests:");
            for (int k = 0; k < reqList.size(); k++) {
                System.out.println(reqList.get(k));
            }
            System.out.println("Drinks selected:");
            drinkList = OrderList.get(i).getBeverages();
            for (int g = 0; g < drinkList.size(); g++) {
                System.out.println(drinkList.get(g));
            }
            System.out.println("total drinks cost: R" +OrderList.get(i).getBevarages_TotalCost());
            System.out.println("Addons:");
            addonList = OrderList.get(i).getAddOns();
            for (int f = 0; f < addonList.size(); f++) {
                System.out.println(addonList.get(f));
            }
            System.out.println("Addons total cost: R" + OrderList.get(i).getAddOns_TotalCost());
            System.out.println("Covid equipment: " + OrderList.get(i).getCovidEquipment() + ", Cost: R" + OrderList.get(i).getCovidEquip_TotalCost());
            System.out.println("Deposit due: " + OrderList.get(i).getDepositPaid()+ ", Deposit amount due: R" + OrderList.get(i).getDepositDue());
            System.out.println("Amount remaining: R" + OrderList.get(i).getRemainingAmount());
            System.out.println("Total cost: R" + OrderList.get(i).getTotalCost());
            System.out.println();
        }
    }
    public void viewClients(){
        System.out.println("Users currently registered:");
        List<Client> clientList = CV.DisplayClientList();
        for (int i = 0; i < clientList.size(); i++) {
            System.out.println(clientList.get(i).getUsername()+","+ clientList.get(i).getFirstname() +", "+ clientList.get(i).getSurname() + ", "+ clientList.get(i).getContactnr()+ ", "+ clientList.get(i).getEmail() +", "+ clientList.get(i).getAddress() + ", admin rights: "+ clientList.get(i).getAdminRights());
        }
    }
    public void viewFoods(){
        System.out.println("Foods currently offered:");
        List<Food> FoodList = FV.GetFood("Starter");
        for (int i = 0; i < FoodList.size(); i++) {
            System.out.println(FoodList.get(i).getFoodCourseType() + ", "+ FoodList.get(i).getFoodName()+ ", R"+ FoodList.get(i).getFoodPrice());             
        }
        FoodList = FV.GetFood("Main");
        for (int i = 0; i < FoodList.size(); i++) {
            System.out.println(FoodList.get(i).getFoodCourseType() + ", "+ FoodList.get(i).getFoodName()+ ", R"+ FoodList.get(i).getFoodPrice());             
        }
        FoodList = FV.GetFood("Desert");
        for (int i = 0; i < FoodList.size(); i++) {
            System.out.println(FoodList.get(i).getFoodCourseType() + ", "+ FoodList.get(i).getFoodName()+ ", R"+ FoodList.get(i).getFoodPrice());             
        }
    }
    public void viewDrinks(){
        System.out.println("Drinks Currently Offered:");
        List<Beverage> drinksList = BV.GetBeverages();
        for (int i = 0; i < drinksList.size(); i++) {
            System.out.println(drinksList.get(i).getBeverageName() + ", R" + drinksList.get(i).getBeveragePrice());
        }        
    }
    public void viewAddons(){
        System.out.println("Addons currently offered:");
        List<AddOn> addonList = AOV.GetAddOn();
        for (int i = 0; i < addonList.size(); i++) {
            System.out.println(addonList.get(i).getAddOnName() + ", R" + addonList.get(i).getAddOnPrice());
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
}
