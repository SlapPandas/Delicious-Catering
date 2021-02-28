package BLL;

import java.util.*;

public class AddOn {

    String addonName;
    double addonPrice;

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
    
}
