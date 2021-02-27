package DAL;
import java.util.*;
import BLL.*;

public class BeverageData {
    public List<Beverage> BeveragesList()
    {
        BeverageDataReaderWriter myReader= new BeverageDataReaderWriter();
        List<Beverage> myBeverageList = new ArrayList<>();
        List<String> myBeverageStringList = myReader.FileReader();

        for(int i=0;i<myBeverageStringList.size();i++){
            String[] myHoldingString = myBeverageStringList.get(i).split("#");
            myBeverageList.add(new Beverage(myHoldingString[0], Double.parseDouble(myHoldingString[1])));
        }
        return myBeverageList;
    }
}
