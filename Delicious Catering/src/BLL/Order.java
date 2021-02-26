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

    public double CalculateTotalAdultFoodCost(int nr, double desertprice, double mainprice, double starterprice)
    {
        double adultfoodtc;
        double sum = desertprice + mainprice + starterprice;

        adultfoodtc = sum * nr;

        return adultfoodtc;
    }


    public double CalculateTotalChildFoodCost(int nr, double desertprice, double mainprice, double starterprice)
    {
        double childfoodtc;

        double sum = desertprice + mainprice + starterprice;

        childfoodtc = sum * nr * 0.7; //food for children are calculated at 70% of adult fod price

        return childfoodtc;
    }


    public List<String> GetFoodPrices(List<String> data)
    {
        List<String> foodlist = new ArrayList<>();

        //search through the list to get the corresponding prices

    }

}
