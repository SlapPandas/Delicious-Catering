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
    public List<Beverage> DisplayFoodList(){
        BeverageData mybeverage = new BeverageData();
        return mybeverage.ReadBeveragesList();
    }
}
