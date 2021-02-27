package DAL;
import java.util.*;
import BLL.*;

public class FoodData {
    public List<Food> FoodList(){
    
        FoodDataReaderWriter myReader= new FoodDataReaderWriter();
        List<Food> myFoodList = new ArrayList<>();
        List<String> myFoodStringList = myReader.FileReader();

        for(int i=0;i<myFoodStringList.size();i++){
            String[] myHoldingString = myFoodStringList.get(i).split("#");
            myFoodList.add(new Food(myHoldingString[0],myHoldingString[1], Double.parseDouble(myHoldingString[2])));
        }
        return myFoodList;
    }
}
