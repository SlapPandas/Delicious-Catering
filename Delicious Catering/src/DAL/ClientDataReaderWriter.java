package DAL;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class ClientDataReaderWriter implements ReadWriteInterface {
    /*
        Text File information formatting
        UserName^Password^Name^Surname^PhoneNumber^Email^Address^IsAdmin
    */
    

    public List<String> FileReader() {
        List<String> myClientFileList = new ArrayList<>();
        String localDir = System.getProperty("user.dir");
        try {
            File myClientFile = new File(localDir+"/Delicious Catering/src/DataFiles/food.txt");
            System.out.println(localDir);
            boolean exityes = myClientFile.exists();
            System.out.println("I do exit: " + exityes);
            //Scanner myReader = new Scanner(myFile);
            //while (myReader.hasNextLine()) {
            //    myClientFileList.add(myReader.nextLine());
            //}
            //myReader.close();
        } catch (Exception e) {
        }
        return myClientFileList;
    }
    public boolean FileWriter(String input) {
        return true;
    }
}
