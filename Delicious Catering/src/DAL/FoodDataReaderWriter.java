package DAL;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class FoodDataReaderWriter implements ReadWriteInterface {
    public List<String> FileReader() {
        List<String> myClientFileList = new ArrayList<>();
        String localDir = System.getProperty("user.dir");
        try {
            File myClientFile = new File(localDir+"/Delicious Catering/src/DataFiles/food.txt");
            System.out.println(localDir);
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
