package BLL;

import java.time.*;
import java.util.*;
import DAL.*;
import java.text.*;
import java.lang.Math.*;

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
        List<Food> myFoodList = fd.ReadFoodList();  //getting the list from the text file

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
        List<AddOn> aoList = ad.ReadAddOnList();

        for(int i = 0; i < userchoicesPL.size(); i++)
        {
            for(int j = 0; j < aoList.size(); j++)
            {
                if(userchoicesPL.get(i).equals(aoList.get(j).getAddOnName()))
                {
                    choiceList.add(aoList.get(j));
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

        return Math.round(childfoodtc);
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

    public double CalcuateTotalCost(int adults, int children, List<String> addonList, List<String> bevList, List<String> foodList, boolean dec, boolean covid)
    {
        double totalcost = 0;

        double addons = CalculateTotalAddOnCost(adults + children, GetAddOnChoices(addonList));
        double beverage = CalculateTotalBeverageCost(adults + children, GetBeverageChoices(bevList));
        double childfood = CalculateTotalChildFoodCost(children, GetFoodChoices(foodList));
        double adultfood = CalculateTotalAdultFoodCost(adults, GetFoodChoices(foodList));

        double decocost = 0;
        double covidcost = 0;

        if(dec)
        {
            decocost = 2500.00;
        }

        if(covid)
        {
            covidcost = 1000.00;
        }

        totalcost = addons + beverage + childfood + adultfood + decocost + covidcost;

        return totalcost;
    }

    public boolean CheckDateAvailibility(String eventDate) throws ParseException
    {

        boolean dateAvailable = false;
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                Date myDate = formatter.parse(eventDate);

        OrderData od = new OrderData();
        List<Order> myOrderList = od.ReadOrderList();

        
            if(myDate.before(new Date()))
            {
                dateAvailable = false;
            }
            else 
            {
                dateAvailable = true;

                for(int i = 0; i < myOrderList.size(); i++)
                {
                    if(myDate.equals(myOrderList.get(i).eventDate))
                    {
                         dateAvailable = false;
                         break;
                    }
                    else 
                    {
                        dateAvailable = true;
                    }
                }
            }

        return dateAvailable;
    }

    //runs when client chooses to pay deposit
    public boolean CheckDeposit(int ordernr, String clientname) throws ParseException   
    {

        OrderData od = new OrderData();
        List<Order> myOrderList = od.ReadOrderList();

        boolean cancelledReturn = false;

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            Date date = new Date();

        //find the order

        for(int i = 0; i < myOrderList.size(); i++)
        {
            if(ordernr == myOrderList.get(i).ordernr && clientname.equals(myOrderList.get(i).clientName))
            {
                long difference_In_Time 
                = myOrderList.get(i).eventDate.getTime() - date.getTime(); 
                long difference_In_Days = (difference_In_Time / (1000 * 60 * 60 * 24)) % 365;

                if(difference_In_Days > 15)
                {
                    myOrderList.get(i).depositPaid = true;
                    break;
                }
                else
                {
                    myOrderList.get(i).cancellation = true;     //cancel the order
                    cancelledReturn = true;
                }
            }
        }

        return cancelledReturn;
    }

    public void Cancellation(int ordernr, String username) throws ParseException
    {
        OrderData od = new OrderData();
        List<Order> myOrderList = od.ReadOrderList(); 

        for(int i = 0; i < myOrderList.size(); i++)
        {
            if(ordernr == myOrderList.get(i).ordernr && username.equals(myOrderList.get(i).clientName))
            {
                myOrderList.get(i).cancellation = true;     //cancel the order
            }
        }
    }

    public int GetOrderInfo(String cName, String adress, String type, boolean dec, String theme, Date edate, List<String> food, List<String> bev, List<String> specReq, List<String> addons, boolean covidEq, int childAtt, int aduAtt)
    throws ParseException
    {   

        //order num from text file (count)
        OrderData od = new OrderData();

        int num = od.ReadOrderList().size()+1;

        List<Food> flist = new ArrayList<>();

        double afc = CalculateTotalAdultFoodCost(aduAtt,  GetFoodChoices(food));
        double cfc = CalculateTotalChildFoodCost(childAtt,  GetFoodChoices(food));
        double btc = CalculateTotalBeverageCost(aduAtt + childAtt,  GetBeverageChoices(bev));
        double dtc = 0;

        if(dec)
        {
            dtc = 2500.00;
        }

        double addonsTC = CalculateTotalAddOnCost(aduAtt + childAtt, GetAddOnChoices(addons));

        double covCost = 0;

        if(covidEq)
        {
            covCost = 1000.00;
        }

        boolean canc = false;
        boolean depPaid = false;

        double tc = CalcuateTotalCost(aduAtt,childAtt, addons, bev, food, dec, covidEq);
        double dep = tc/2;
        double remainingAm = tc;

        od.WriteNewOrder(num, cName, adress, type, dec, theme, edate, food, bev, specReq, afc, cfc, btc, dtc, addons, addonsTC, covidEq, covCost, canc, tc, dep, depPaid, remainingAm, childAtt, aduAtt);
    
        return ordernr;
    }

}
