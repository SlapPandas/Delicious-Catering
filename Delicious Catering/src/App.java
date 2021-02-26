import java.util.List;

import DAL.*;
public class App {
    public static void main(String[] args) throws Exception {
        ClientDataReaderWriter the = new ClientDataReaderWriter();
        List<String> myStringList = the.FileReader();
        System.out.println("yes: " + myStringList.size());
    }
}
