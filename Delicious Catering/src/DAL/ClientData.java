package DAL;
import java.util.*;
import javax.swing.JOptionPane;
import BLL.*;

public class ClientData {
    public List<Client> ReadClientList()
    {
        DataReaderWriter myReader= new DataReaderWriter("Client");
        List<Client> myClientList = new ArrayList<>();
        List<String> myClientStringList = myReader.FileReader();
        
        for(int i=0;i<myClientStringList.size();i++){
            String[] myHoldingString = myClientStringList.get(i).split("#");
            myClientList.add(new Client(myHoldingString[0], myHoldingString[1], myHoldingString[2], myHoldingString[3], 
                                        Integer.parseInt(myHoldingString[4]), myHoldingString[5], myHoldingString[6], CheckTrueFalse(myHoldingString[7])));
        }
        return myClientList;
    }
    public void WriteNewClient(String username,String password,String FirstName,String surname,String contactnumber,String email,String address,Boolean adminRights)
    {
        DataReaderWriter myWriter= new DataReaderWriter("Client");
        if(myWriter.FileWriter(username+"#"+password+"#"+FirstName+"#"+surname+"#"+contactnumber+"#"+email+"#"+address+"#"+adminRights)!=true){
            JOptionPane.showMessageDialog(null, "Could not write client To file");
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
