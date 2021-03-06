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
    

    public void runAdminMenu() throws Exception{
        Boolean exitSelected = false;
        while (!exitSelected) {
            System.out.println("1) view all orders");
            System.out.println("2) view all clients");
            System.out.println("3) View the full menu");
            System.out.println("4) View all the drinks");
            System.out.println("5) View all addons");
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
                default:
                    System.out.println("Please enter a valid input\n");
                    break;
            }
        }
    }

    public void viewOrders()throws Exception{
        List<Order> OrderList = OV.GetAllOrders();
        for (int i = 0; i < OrderList.size(); i++) {
            System.out.println(OrderList.get(i).getUserName() + ", " + OrderList.get(i).getOrdernr() + ", " + OrderList.get(i).getCancellation() + ", "+ OrderList.get(i).getEventAddress() + ", "+ OrderList.get(i).getEventType() + );
        }
    }
    public void viewClients(){

    }
    public void viewFoods(){

    }
    public void viewDrinks(){

    }
    public void viewAddons(){
        
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
    // add to files logic
}
