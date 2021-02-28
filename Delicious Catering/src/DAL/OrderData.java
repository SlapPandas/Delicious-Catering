package DAL;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import javax.swing.JOptionPane;
import BLL.*;

public class OrderData {
    public List<Order> ReadOrderList(){
    
        DataReaderWriter myReader= new DataReaderWriter("Food");
        List<Order> myOrderList = new ArrayList<>();
        List<String> myOrderStringList = myReader.FileReader();

        for(int i=0;i<myOrderStringList.size();i++){
            String[] myHoldingString = myOrderStringList.get(i).split("#");

            String[] myFoodHoldingString = myHoldingString[7].split("@");
            List<String> myFood = new ArrayList<>();
            for(int j=0;j<myFoodHoldingString.length;j++){myFood.add(myFoodHoldingString[j]);}
            //List<String> myFood = Arrays.asList(myFoodHoldingString);

            String[] mybeveragesHoldingString = myHoldingString[8].split("@");
            List<String> myBeverages = new ArrayList<>();
            for(int j=0;j<mybeveragesHoldingString.length;j++){myFood.add(mybeveragesHoldingString[j]);}
            //List<String> myBeverages = Arrays.asList(mybeveragesHoldingString);

            String[] myspecialFoodRequestHoldingString = myHoldingString[9].split("@");
            List<String> mySpecialFoodRequest = new ArrayList<>();
            for(int j=0;j<myspecialFoodRequestHoldingString.length;j++){myFood.add(myspecialFoodRequestHoldingString[j]);}
            //List<String> mySpecialFoodRequest = Arrays.asList(myspecialFoodRequestHoldingString);

            String[] myaddOnsHoldingString = myHoldingString[14].split("@");
            List<String> myAddOns = new ArrayList<>();
            for(int j=0;j<myaddOnsHoldingString.length;j++){myFood.add(myaddOnsHoldingString[j]);}
            //List<String> addOns = Arrays.asList(myaddOnsHoldingString);

            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            try{
                Date myDate = formatter.parse(myHoldingString[6]);

                myOrderList.add(new Order(Integer.parseInt(myHoldingString[0]),myHoldingString[1],myHoldingString[2],myHoldingString[3],CheckTrueFalse(myFoodHoldingString[4]),
                                            myHoldingString[5],myDate,myFood,myBeverages,mySpecialFoodRequest,Double.parseDouble(myHoldingString[10]),
                                            Double.parseDouble(myHoldingString[11]),Double.parseDouble(myHoldingString[12]),Double.parseDouble(myHoldingString[13]),myAddOns,
                                            Double.parseDouble(myHoldingString[15]),CheckTrueFalse(myHoldingString[16]),Double.parseDouble(myHoldingString[17]),
                                            CheckTrueFalse(myHoldingString[18]),Double.parseDouble(myHoldingString[19]),Double.parseDouble(myHoldingString[20]),
                                            CheckTrueFalse(myHoldingString[21]),Double.parseDouble(myHoldingString[22]),Integer.parseInt(myHoldingString[22]),
                                            Integer.parseInt(myHoldingString[23])));
            }catch(ParseException e){}
            

            

        }
        return myOrderList;
    }
    public void WriteNewOrder(String course,String name,Double price)
    {
        DataReaderWriter myWriter= new DataReaderWriter("Food");
        if(myWriter.FileWriter(course+"#"+name+"#"+price)!=true){
            JOptionPane.showMessageDialog(null, "Could not write beverage To file");
        }
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
