package DAL;
import java.util.*;
import javax.swing.JOptionPane;
import BLL.*;

public class BeverageData {
    public List<Beverage> ReadBeveragesList()
    {
        DataReaderWriter myReader= new DataReaderWriter("Beverage");
        List<Beverage> myBeverageList = new ArrayList<>();
        List<String> myBeverageStringList = myReader.FileReader();

        for(int i=0;i<myBeverageStringList.size();i++){
            String[] myHoldingString = myBeverageStringList.get(i).split("#");
            myBeverageList.add(new Beverage(myHoldingString[0], Double.parseDouble(myHoldingString[1])));
        }
        return myBeverageList;
    }
    public void WriteNewBeverage(String name,Double price)
    {
        DataReaderWriter myWriter= new DataReaderWriter("Beverage");
        if(myWriter.FileWriter(name+"#"+price)!=true){
            JOptionPane.showMessageDialog(null, "Could not write beverage To file");
        }
    }
}
