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

    public List<AddOn> GetAddOn()
    {
        AddOnData addondata = new AddOnData();
        List<AddOn> addonlist = new ArrayList<>();
        List<AddOn> myAddOnList = addondata.ReadAddOnList();

        for(int i = 0; i < myAddOnList.size(); i++)
        {
            addonlist.add(myAddOnList.get(i));
        }

        return addonlist;
    }

    
    public boolean CheckAddOnsExists(String addon) throws ParseException
    {
        boolean exists = false;

        AddOnData od = new AddOnData();

        List<AddOn> addonList = od.ReadAddOnList();

        for(int i = 0; i < addonList.size(); i++)
        {
            if (addonList.get(i).getAddOnName().equals(addon))
            {
                exists = true;
                break;
            } 
        }
        return exists;
    }
    
}
