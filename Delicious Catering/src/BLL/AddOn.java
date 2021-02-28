package BLL;

import java.util.*;

import DAL.AddOnData;

public class AddOn {

    String addonName;
    double addonPrice;

    public AddOn(){}
    public AddOn(String name, double price)
    {
        this.addonName = name;
        this.addonPrice = price;
    }

    public String getAddOnName() {
        return addonName;
    }
    public double getAddOnPrice() {
        return addonPrice;
    }
    public List<AddOn> DisplayAddOnList(){
        AddOnData myAddOn = new AddOnData();
        return myAddOn.ReadAddOnList();
    }
    
}
