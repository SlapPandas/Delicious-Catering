package DAL;
import java.util.*;
import BLL.*;

public class ClientData {
    public List<Client> ClientList()
    {
        ClientDataReaderWriter myReader= new ClientDataReaderWriter();
        List<Client> myClientList = new ArrayList<>();
        List<String> myClientStringList = myReader.FileReader();
        
        for(int i=0;i<myClientStringList.size();i++){
            String[] myHoldingString = myClientStringList.get(i).split("#");
            myClientList.add(new Client(myHoldingString[0], myHoldingString[1], myHoldingString[2], myHoldingString[3], Integer.parseInt(myHoldingString[4]), myHoldingString[5], myHoldingString[6], CheckTrueFalse(myHoldingString[7])));
        }
        return myClientList;
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
