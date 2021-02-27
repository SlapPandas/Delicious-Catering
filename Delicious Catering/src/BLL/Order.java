package BLL;

import java.time.*;
import java.util.*;

public class Order {
    
    private int ordernr;
    private String clientName;
    private String eventAddress;
    private String eventType;
    private boolean decoration;
    private String theme;
    private LocalDate eventDate;

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

    public Order(int num, String cName, String adress, String type, boolean dec, String theme, LocalDate edate, List<String> food, List<String> bev, List<String> specReq, double afc, double cfc, double btc, double dtc, List<String> addons, double addonsTC, boolean covidEq, double covCost, boolean canc, double TC, double dep, boolean depositPaid, double remainingAm, int childAtt, int aduAtt)
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
        this.totalCost = TC;
        this.depositDue = dep;
        this.depositPaid = depositPaid;
        this.remainingAmount = remainingAm;
        this.childrenAttending = childAtt;
        this.adultsAttending = aduAtt;
    }

    public double CalculateTotalAdultFoodCost(int nr, List<Double> foodprices)
    {
        double adultfoodtc;
        double desertprice = foodprices.get(2);
        double mainprice= foodprices.get(1);
        double starterprice = foodprices.get(0);

        double sum = desertprice + mainprice + starterprice;

        adultfoodtc = sum * nr;

        return adultfoodtc;
    }


    public double CalculateTotalChildFoodCost(int nr, List<Double> foodprices)
    {
        double childfoodtc;
        double desertprice = foodprices.get(2);
        double mainprice= foodprices.get(1);
        double starterprice = foodprices.get(0);

        double sum = desertprice + mainprice + starterprice;

        childfoodtc = sum * nr * 0.7; //food for children are calculated at 70% of adult fod price

        return childfoodtc;
    }


    public List<Double> GetFoodPrices(List<String> data, List<String> foodchoice)
    {
        //data is from DAL & foodchoice from presentation layer

        List<Double> foodprices = new ArrayList<>(); //a simple list containing the prices of the food items to use in calculations

        for(int i = 0; i < foodchoice.size(); i++)
        {
            for(int j = 0; j < data.size(); j++)
            {
                if(foodchoice.get(i).equals(data.get(j)))
                {
                    String choice = data.get(i);
                    String price = choice.split("^",3)[3];
                    foodprices.add(Double.parseDouble(price));
                    break;
                }
            }
        }

        return foodprices;

        //search through the list to get the corresponding prices

    }

}
