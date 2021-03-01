package DAL;

import java.util.List;

public interface ReadWriteInterface {
    public boolean ClearLife();
    public List<String> FileReader();
    public boolean FileWriter(String input);
    public  boolean FileUpdater(String input);
}
