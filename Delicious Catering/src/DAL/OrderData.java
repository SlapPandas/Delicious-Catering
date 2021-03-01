package DAL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.swing.JOptionPane;
import BLL.*;

public class OrderData {
    public List<Order> ReadOrderList() throws ParseException {
    
        DataReaderWriter myReader= new DataReaderWriter("Order");
        List<Order> myOrderList = new ArrayList<>();
        List<String> myOrderStringList = myReader.FileReader();

        for(int i=0;i<myOrderStringList.size();i++){
            String[] myHoldingString = myOrderStringList.get(i).split("#");

            String[] myFoodHoldingString = myHoldingString[7].split("@");
            List<String> myFood = new ArrayList<>();
            for(int j=0;j<myFoodHoldingString.length;j++){myFood.add(myFoodHoldingString[j]);}

            String[] mybeveragesHoldingString = myHoldingString[8].split("@");
            List<String> myBeverages = new ArrayList<>();
            for(int j=0;j<mybeveragesHoldingString.length;j++){myBeverages.add(mybeveragesHoldingString[j]);}

            String[] myspecialFoodRequestHoldingString = myHoldingString[9].split("@");
            List<String> mySpecialFoodRequest = new ArrayList<>();
            for(int j=0;j<myspecialFoodRequestHoldingString.length;j++){mySpecialFoodRequest.add(myspecialFoodRequestHoldingString[j]);}

            String[] myaddOnsHoldingString = myHoldingString[14].split("@");
            List<String> myAddOns = new ArrayList<>();
            for(int j=0;j<myaddOnsHoldingString.length;j++){myAddOns.add(myaddOnsHoldingString[j]);}

            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                Date myDate = formatter.parse(myHoldingString[6]);
                myOrderList.add(new Order(Integer.parseInt(myHoldingString[0]),myHoldingString[1],myHoldingString[2],myHoldingString[3],
                                          CheckTrueFalse(myHoldingString[4]),myHoldingString[5],myDate,myFood,myBeverages,mySpecialFoodRequest,
                                          Double.parseDouble(myHoldingString[10]),Double.parseDouble(myHoldingString[11]),
                                          Double.parseDouble(myHoldingString[12]),Double.parseDouble(myHoldingString[13]),myAddOns,
                                          Double.parseDouble(myHoldingString[15]),CheckTrueFalse(myHoldingString[16]),
                                          Double.parseDouble(myHoldingString[17]),CheckTrueFalse(myHoldingString[18]),
                                          Double.parseDouble(myHoldingString[19]),Double.parseDouble(myHoldingString[20]),
                                          CheckTrueFalse(myHoldingString[21]),Double.parseDouble(myHoldingString[22]),
                                          Integer.parseInt(myHoldingString[23]),Integer.parseInt(myHoldingString[24])));
        }
        return myOrderList;
    }
    public void WriteNewOrder(int ordernr,String clientName,String eventAddress,String eventType,boolean decoration,String theme,Date eventDate,List<String> food,
                              List<String> beverages,List<String> specialFoodRequest,Double adultFood_TotalCost,Double childFood_TotalCost,Double bevarages_TotalCost,
                              Double decoration_TotalCost,List<String> addOns,Double addOns_TotalCost,boolean covidEquipment,Double covidEquip_TotalCost,boolean cancellation,
                              Double totalCost,Double depositDue,boolean depositPaid,Double remainingAmount,int childrenAttending,int adultsAttending)
    { 
        DataReaderWriter myWriter= new DataReaderWriter("Order");
        DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");  
        String myDate = dateFormat.format(eventDate);
        if(myWriter.FileWriter(ordernr+"#"+clientName+"#"+eventAddress+"#"+eventType+"#"+ConvertBoolToLetter(decoration)+"#"+theme+"#"+
                                myDate+"#"+food(food)+"#"+beverages(beverages)+"#"+specialFoodRequests(specialFoodRequest)+"#"+adultFood_TotalCost+"#"+childFood_TotalCost+"#"+
                                bevarages_TotalCost+"#"+decoration_TotalCost+"#"+addons(addOns)+"#"+addOns_TotalCost+"#"+ConvertBoolToLetter(covidEquipment)+"#"+covidEquip_TotalCost+"#"+
        ConvertBoolToLetter(cancellation)+"#"+totalCost+"#"+depositDue+"#"+ConvertBoolToLetter(depositPaid)+"#"+remainingAmount+"#"+childrenAttending+"#"+adultsAttending)!=true){
            JOptionPane.showMessageDialog(null, "Could not write beverage To file");
        }
    }
    public void UpdateOrder(int ordernr,String clientName,String eventAddress,String eventType,boolean decoration,String theme,Date eventDate,List<String> food,
                              List<String> beverages,List<String> specialFoodRequest,Double adultFood_TotalCost,Double childFood_TotalCost,Double bevarages_TotalCost,
                              Double decoration_TotalCost,List<String> addOns,Double addOns_TotalCost,boolean covidEquipment,Double covidEquip_TotalCost,boolean cancellation,
                              Double totalCost,Double depositDue,boolean depositPaid,Double remainingAmount,int childrenAttending,int adultsAttending)
            throws ParseException
    {
        DataReaderWriter myReadWriter= new DataReaderWriter("Order");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");  
        String myDate = dateFormat.format(eventDate);
        List<Order> myOldOrderList = ReadOrderList();
        List<String> myOldOrderStringList = myReadWriter.FileReader();
        List<String> myNewOrderStringList = new ArrayList<>();

        for(int i =0;i<myOldOrderStringList.size();i++){
            if(ordernr == myOldOrderList.get(i).getOrdernr()){
                myNewOrderStringList.add(ordernr+"#"+clientName+"#"+eventAddress+"#"+eventType+"#"+ConvertBoolToLetter(decoration)+"#"+theme+"#"+
                myDate+"#"+food(food)+"#"+beverages(beverages)+"#"+specialFoodRequests(specialFoodRequest)+"#"+adultFood_TotalCost+"#"+childFood_TotalCost+"#"+
                bevarages_TotalCost+"#"+decoration_TotalCost+"#"+addons(addOns)+"#"+addOns_TotalCost+"#"+ConvertBoolToLetter(covidEquipment)+"#"+covidEquip_TotalCost+"#"+
                ConvertBoolToLetter(cancellation)+"#"+totalCost+"#"+depositDue+"#"+ConvertBoolToLetter(depositPaid)+"#"+remainingAmount+"#"+childrenAttending+"#"+adultsAttending);
            }else{
                myNewOrderStringList.add(myOldOrderStringList.get(i));
            }
        }
        //myReadWriter.ClearLife();
        for(int j =0;j<myNewOrderStringList.size();j++){
            //myReadWriter.FileUpdater(myNewOrderStringList.get(j));
        }
             
    }
    private String food(List<String> food){
        String myfood = "";
        for(int i=0;i<food.size();i++){myfood += food.get(i)+"@";}
        return myfood.substring(0, myfood.length() - 1);
    }
    private String beverages(List<String> beverages){
        String mybeverages= "";
        for(int i=0;i<beverages.size();i++){mybeverages += beverages.get(i)+"@";}
        return mybeverages.substring(0, mybeverages.length() - 1);
    }
    private String specialFoodRequests(List<String> specialFoodRequest){
        String myspecialFoodRequest= "";
        for(int i=0;i<specialFoodRequest.size();i++){myspecialFoodRequest += specialFoodRequest.get(i)+"@";}
        return myspecialFoodRequest.substring(0, myspecialFoodRequest.length() - 1);
    }
    private String addons(List<String> addOns){
        String myaddOns= "";
        for(int i=0;i<addOns.size();i++){myaddOns += addOns.get(i)+"@";}
        return myaddOns.substring(0, myaddOns.length() - 1);
    }
    private String ConvertBoolToLetter(boolean input)
    {
        String output = "";
        if(input == true){output="T";}
        if(input == false){output="F";}
        return output;
    }
    private boolean CheckTrueFalse(String input)
    {
        boolean output = false;
        switch(input){
            case "T":
                output = true;
                break;
            case "F":
                output = false;
                break;
        }
        return output;
    }
}
