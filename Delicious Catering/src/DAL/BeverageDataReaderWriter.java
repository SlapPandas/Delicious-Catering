package DAL;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class BeverageDataReaderWriter implements ReadWriteInterface {
    private String FilePath(){
        
        String localDir = System.getProperty("user.dir");
        String fP = localDir + "/Delicious Catering/src/DataFiles/Beverage.txt";
        return fP;
    }

    public List<String> FileReader() {
        List<String> myClientFileList = new ArrayList<>();
        
        try {
            File myClientFile = new File(FilePath());
            Scanner myReader = new Scanner(myClientFile);
            while (myReader.hasNextLine()) 
            {
                myClientFileList.add(myReader.nextLine());
            }
            myReader.close();
        } catch (Exception e) {
        }
        return myClientFileList;
    }
    
    public boolean FileWriter(String name,String price) {
        boolean writtenToFile;
        try {
            FileWriter myWriter = new FileWriter(FilePath());
            myWriter.write(name + "^" + price);
            myWriter.close();
            writtenToFile = true;
          } catch (IOException e) {
            writtenToFile = false;
          }
        return writtenToFile;
    }
}
