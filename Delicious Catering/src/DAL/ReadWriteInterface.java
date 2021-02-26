package DAL;

import java.util.List;

public interface ReadWriteInterface {
    public List<String> FileReader();
    public boolean FileWriter(String Input);
}
