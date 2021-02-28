package DAL;
import java.util.*;
import javax.swing.JOptionPane;
import BLL.*;

public class AddOnData {
    public List<AddOn> ReadAddOnList()
    {
        DataReaderWriter myReader= new DataReaderWriter("AddOn");
        List<AddOn> myAddOnList = new ArrayList<>();
        List<String> myAddOnStringList = myReader.FileReader();

        for(int i=0;i<myAddOnStringList.size();i++){
            String[] myHoldingString = myAddOnStringList.get(i).split("#");
            myAddOnList.add(new AddOn(myHoldingString[0], Double.parseDouble(myHoldingString[1])));
        }
        return myAddOnList;
    }
    public void WriteNewAddOn(String name,Double price)
    {
        DataReaderWriter myWriter= new DataReaderWriter("AddOn");
        if(myWriter.FileWriter(name+"#"+price)!=true){
            JOptionPane.showMessageDialog(null, "Could not write Addon To file");
        }
    }
}
