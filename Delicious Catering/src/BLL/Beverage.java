package BLL;

public class Beverage {
    private String beverageName;
    private double beveragePrice;

    public Beverage(String name, Double price){
        this.beverageName = name;
        this.beveragePrice = price;
    }
    public String GetBeverageName(){
        return this.beverageName;
    }
    public Double GetBeveragePrice(){
        return this.beveragePrice;
    }
}
