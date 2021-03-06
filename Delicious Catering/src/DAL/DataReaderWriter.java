package DAL;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class DataReaderWriter implements ReadWriteInterface {
    String myFileName;

    public DataReaderWriter(String myfileToAccess) {
        this.myFileName = myfileToAccess;
    }

    private String FilePath() {

        String localDir = System.getProperty("user.dir");
        String fP = localDir + "/Delicious Catering/src/DataFiles/" + myFileName + ".txt";
        return fP;
    }

    public List<String> FileReader() {
        List<String> myFileList = new ArrayList<>();
        try {
            File myFile = new File(FilePath());
            Scanner myReader = new Scanner(myFile);
            while (myReader.hasNextLine()) {
                myFileList.add(myReader.nextLine());
            }
            myReader.close();
        } catch (Exception e) {
        }
        return myFileList;
    }

    public boolean FileWriter(String input) {
        boolean writtenToFile;
        try {
            FileWriter fstream = new FileWriter(FilePath(), true);
            BufferedWriter out = new BufferedWriter(fstream);
            out.write(input);
            out.newLine();
            out.close();
            writtenToFile = true;
        } catch (IOException e) {
            writtenToFile = false;
        }
        return writtenToFile;
    }
    public boolean ClearLife(){
        boolean success;
        try {
            PrintWriter pw = new PrintWriter(FilePath());
            pw.close();
            success = true;
        } catch (FileNotFoundException e1) {
            success = false;
        }
        return success;
    }
    public boolean FileUpdater(String input) {
        boolean writtenToFile;
            try {
                FileWriter filestream = new FileWriter(FilePath(),true);
                BufferedWriter output = new BufferedWriter(filestream);
                output.write(input);
                output.newLine();
                output.close();
                writtenToFile = true;
              } catch (IOException e) {
                writtenToFile = false;
              }
        
        return writtenToFile;
    }
}
