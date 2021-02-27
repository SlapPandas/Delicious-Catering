package DAL;
import java.io.File;
import java.util.*;

public class OrderDataReaderWriter implements ReadWriteInterface {
    public List<String> FileReader() {
        List<String> myClientFileList = new ArrayList<>();
        String localDir = System.getProperty("user.dir");
        try {
            File myClientFile = new File(localDir+"/Delicious Catering/src/DataFiles/OrderData.txt");
            Scanner myReader = new Scanner(myClientFile);
            while (myReader.hasNextLine()) {
                myClientFileList.add(myReader.nextLine());
            }
            myReader.close();
        } catch (Exception e) {
        }
        return myClientFileList;
    }
    
    public boolean FileWriter(String input) {
        return true;
    }
}
