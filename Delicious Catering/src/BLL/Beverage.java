package BLL;

import java.util.*;

import DAL.BeverageData;


public class Beverage {
    private String beverageName;
    private double beveragePrice;

    public Beverage(){}
    public Beverage(String name, Double price){
        this.beverageName = name;
        this.beveragePrice = price;
    }
    public String getBeverageName() {
        return beverageName;
    }
    public double getBeveragePrice() {
        return beveragePrice;
    }
    public List<Beverage> DisplayBeverageList(){
        BeverageData mybeverage = new BeverageData();
        return mybeverage.ReadBeveragesList();
    }

    public List<Beverage> GetBeverages()
    {
        BeverageData bevData = new BeverageData();
        List<Beverage> beveragelist = new ArrayList<>();
        List<Beverage> myBevList = bevData.ReadBeveragesList();

        for(int i = 0; i < myBevList.size(); i++)
        {
            beveragelist.add(myBevList.get(i));
        }

        return beveragelist;

    }

    public boolean CheckBeverageExists(String beverage)
    {
        boolean exists = false;

        BeverageData od = new BeverageData();

        List<Beverage> beverageList = od.ReadBeveragesList();

        for(int i = 0; i < beverageList.size(); i++)
        {
            if (beverageList.get(i).getBeverageName().equals(beverage))
            {
                exists = true;
                break;
            } 
        }
        return exists;
    }
}
