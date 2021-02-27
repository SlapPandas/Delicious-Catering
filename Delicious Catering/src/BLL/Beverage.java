package BLL;

public class Beverage {
    private String beverageName;
    private double beveragePrice;

    public Beverage(String Name, Double Price){
        this.beverageName = Name;
        this.beveragePrice = Price;
    }
    public String GetBeverageName(){
        return this.beverageName;
    }
    public Double GetBeveragePrice(){
        return this.beveragePrice;
    }
}
