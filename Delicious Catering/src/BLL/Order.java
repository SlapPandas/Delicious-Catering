package BLL;

import java.time.*;
import java.util.*;
import DAL.*;
import javax.swing.JOptionPane;

public class Order {
    
    private int ordernr;
    private String clientName;
    private String eventAddress;
    private String eventType;
    private boolean decoration;
    private String theme;
    private Date eventDate;

    private List<String> food;
    private List<String> beverages;
    private List<String> specialFoodRequest;
    private double adultFood_TotalCost;
    private double childFood_TotalCost;
    private double bevarages_TotalCost;

    private double decoration_TotalCost;
    private List<String> addOns;
    private double addOns_TotalCost;
    private boolean covidEquipment;
    private double covidEquip_TotalCost;

    private boolean cancellation;

    private double totalCost;
    private double depositDue;
    private boolean depositPaid;
    private double remainingAmount;

    private int childrenAttending;
    private int adultsAttending;

    public Order(){};

    public Order(int num, String cName, String adress, String type, boolean dec, String theme, Date edate, List<String> food, List<String> bev, List<String> specReq, double afc, double cfc, double btc, double dtc, List<String> addons, double addonsTC, boolean covidEq, double covCost, boolean canc, double tc, double dep, boolean depositPaid, double remainingAm, int childAtt, int aduAtt)
    {
        this.ordernr = num;
        this.clientName = cName;
        this.eventAddress = adress;
        this.eventType = type;
        this.decoration = dec;
        this.theme = theme;
        this.eventDate = edate;
        this.food = food;
        this.beverages = bev;
        this.specialFoodRequest = specReq;
        this.adultFood_TotalCost = afc;
        this.childFood_TotalCost = cfc;
        this.bevarages_TotalCost = btc;
        this.decoration_TotalCost = dtc;
        this.addOns = addons;
        this.addOns_TotalCost = addonsTC;
        this.covidEquipment = covidEq;
        this.cancellation = canc;
        this.covidEquip_TotalCost = covCost;
        this.totalCost = tc;
        this.depositDue = dep;
        this.depositPaid = depositPaid;
        this.remainingAmount = remainingAm;
        this.childrenAttending = childAtt;
        this.adultsAttending = aduAtt;
    }
    public int getOrdernr() {
        return ordernr;
    }
    public String getClientName() {
        return clientName;
    }
    public String getEventAddress() {
        return eventAddress;
    }
    public String getEventType() {
        return eventType;
    }
    public Boolean getDecoration(){
        return decoration;
    }
    public String getTheme() {
        return theme;
    }
    public Date getEventDate() {
        return eventDate;
    }
    public List<String> getFood() {
        return food;
    }
    public List<String> getBeverages() {
        return beverages;
    }
    public List<String> getSpecialFoodRequest() {
        return specialFoodRequest;
    }
    public double getAdultFood_TotalCost() {
        return adultFood_TotalCost;
    }
    public double getChildFood_TotalCost() {
        return childFood_TotalCost;
    }
    public double getBevarages_TotalCost() {
        return bevarages_TotalCost;
    }
    public double getDecoration_TotalCost() {
        return decoration_TotalCost;
    }
    public List<String> getAddOns() {
        return addOns;
    }
    public double getAddOns_TotalCost() {
        return addOns_TotalCost;
    }
    public Boolean getCovidEquipment(){
        return covidEquipment;
    }
    public double getCovidEquip_TotalCost() {
        return covidEquip_TotalCost;
    }
    public Boolean getCancellation(){
        return cancellation;
    }
    public double getTotalCost() {
        return totalCost;
    }
    public double getDepositDue() {
        return depositDue;
    }
    public Boolean getDepositPaid(){
        return depositPaid;
    }
    public double getRemainingAmount() {
        return remainingAmount;
    }
    public int getChildrenAttending() {
        return childrenAttending;
    }
    public int getAdultsAttending() {
        return adultsAttending;
    }


    public List<Food> GetFoodChoices(List<String> userchoicesPL)
    {
        List<Food> choiceList = new ArrayList<>();

        FoodData fd = new FoodData();

        List<Food> myFoodList = fd.ReadFoodList();

        for(int i = 0; i < userchoicesPL.size(); i++)
        {
            for(int j = 0; j < myFoodList.size(); j++)
            {
                if(userchoicesPL.get(i).equals(myFoodList.get(j).getFoodName()))
                {
                    choiceList.add(myFoodList.get(j));
                }
            }
        }

        return choiceList;
    }

    public List<Beverage> GetBeverageChoices(List<String> userchoicesPL)
    {
        List<Beverage> choiceList = new ArrayList<>();

        BeverageData bd = new BeverageData();

        List<Beverage> myBeverageList = bd.ReadBeveragesList();

        for(int i = 0; i < userchoicesPL.size(); i++)
        {
            for(int j = 0; j < myBeverageList.size(); j++)
            {
                if(userchoicesPL.get(i).equals(myBeverageList.get(j).getBeverageName()))
                {
                    choiceList.add(myBeverageList.get(j));
                }
            }
        }

        return choiceList;
    }

    public List<AddOn> GetAddOnChoices(List<String> userchoicesPL)
    {
        List<AddOn> choiceList = new ArrayList<>();

        AddOnData ad = new AddOnData();

        List<AddOn> myAddOnList = ad.ReadAddOnList();

        for(int i = 0; i < userchoicesPL.size(); i++)
        {
            for(int j = 0; j < myAddOnList.size(); j++)
            {
                if(userchoicesPL.get(i).equals(myAddOnList.get(j).getAddOnName()))
                {
                    choiceList.add(myAddOnList.get(j));
                }
            }
        }

        return choiceList;
    }

    public double CalculateTotalAdultFoodCost(int nr, List<Food> choicelist)
    {
        double adultfoodtc;
        double desertprice = choicelist.get(2).getFoodPrice();
        double mainprice= choicelist.get(1).getFoodPrice();
        double starterprice = choicelist.get(0).getFoodPrice();

        double sum = desertprice + mainprice + starterprice;

        if(nr >= 40)
        {
            sum *= 0.85;    //client qualifies for a 15% discount
        }

        adultfoodtc = sum * nr;

        return adultfoodtc;
    }


    public double CalculateTotalChildFoodCost(int nr, List<Food> choicelist)
    {
        double childfoodtc;
        double desertprice = choicelist.get(2).getFoodPrice();
        double mainprice= choicelist.get(1).getFoodPrice();
        double starterprice = choicelist.get(0).getFoodPrice();

        double sum = desertprice + mainprice + starterprice;

        childfoodtc = sum * nr * 0.7; //food for children are calculated at 70% of adult fod price

        return childfoodtc;
    }

    public double CalculateTotalBeverageCost(int nr, List<Beverage> choicelist)
    {
        double beveragecost = 0;
        
        for(int i =0; i < choicelist.size(); i++)
        {
            beveragecost += choicelist.get(i).getBeveragePrice();
        }

        return beveragecost*nr;
        //cost of beverages multiplied by the number of guests attending
    }

    public double CalculateTotalAddOnCost(int nr, List<AddOn> choicelist)
    {
        double addoncost = 0;
        
        for(int i =0; i < choicelist.size(); i++)
        {
            addoncost += choicelist.get(i).getAddOnPrice();
        }

        return addoncost*nr;
        //cost of beverages multiplied by the number of guests attending
    }

    public double CalcuateTotalCost()
    {
        double totalcost = 0;

        double addons = CalculateTotalAddOnCost(adultsAttending + childrenAttending, GetAddOnChoices(food));
        double beverage = CalculateTotalBeverageCost(adultsAttending + childrenAttending, GetBeverageChoices(beverages));
        double childfood = CalculateTotalChildFoodCost(childrenAttending, GetFoodChoices(food));
        double adultfood = CalculateTotalAdultFoodCost(adultsAttending, GetFoodChoices(food));

        double decocost = 0;
        double covidcost = 0;

        if(decoration)
        {
            decocost = 2500.00;
        }

        if(covidEquipment)
        {
            covidcost = 1000.00;
        }

        totalcost = addons + beverage + childfood + adultfood + decocost + covidcost;

        return totalcost;
    }

    //check deposit
    //cancellation

    public void CheckDateAvailibility(List<Order> myOrderList, Date eventDate)
    {

        

        if()
            {
                JOptionPane.showMessageDialog(null, "Date is not available, sorry! Please choose another.");
                break;
            }

        for(int i = 0; i < myOrderList.size(); i++)
        {
            if(eventDate.equals(myOrderList.get(i).eventDate))
            {
                JOptionPane.showMessageDialog(null, "Date is not available, sorry! Please choose another.");
                break;
            }
        }
    }

}
