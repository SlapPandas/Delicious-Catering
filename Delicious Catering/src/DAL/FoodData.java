package DAL;
import java.util.*;
import BLL.*;
import javax.swing.JOptionPane;

public class FoodData {
    public List<Food> ReadFoodList(){
    
        DataReaderWriter myReader= new DataReaderWriter("Food");
        List<Food> myFoodList = new ArrayList<>();
        List<String> myFoodStringList = myReader.FileReader();

        for(int i=0;i<myFoodStringList.size();i++){
            String[] myHoldingString = myFoodStringList.get(i).split("#");
            myFoodList.add(new Food(CourseFullName(myHoldingString[0]),myHoldingString[1], Double.parseDouble(myHoldingString[2])));
        }
        return myFoodList;
    }
    public void WriteNewFood(String course,String name,Double price)
    {
        DataReaderWriter myWriter= new DataReaderWriter("Food");
        if(myWriter.FileWriter(CourseShortName(course)+"#"+name+"#"+price)!=true){
            JOptionPane.showMessageDialog(null, "Could not write beverage To file");
        }
    }
    private String CourseFullName(String input){
        String output = "";
        switch(input){
            case "S":
            output = "Starter";
            break;
            case "M":
            output = "Main";
            break;
            case "D":
            output = "Dessert";
            break;
        }
        return output;
    }
    private String CourseShortName(String input){
        String output = "";
        switch(input){
            case "Starter":
            output = "S";
            break;
            case "Main":
            output = "M";
            break;
            case "Dessert":
            output = "D";
            break;
        }
        return output;
    }
}
