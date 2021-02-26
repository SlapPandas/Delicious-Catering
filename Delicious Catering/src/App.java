import java.util.List;

import DAL.*;
public class App {
    public static void main(String[] args) throws Exception {
        ClientDataReaderWriter the = new ClientDataReaderWriter();
        List<String> myStringList = the.FileReader();
        System.out.println("yes: " + myStringList.size());
        System.out.println("Hello, World!");
        String localDir = System.getProperty("user.dir");
        System.out.println(localDir+"/Delicious Catering/src/DataFiles/food.txt");
        //there are dead People
    }
}
