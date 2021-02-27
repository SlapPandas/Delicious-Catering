import java.util.*;

import BLL.*;
import DAL.*;
public class App {
    public static void main(String[] args) throws Exception {
        ClientData the = new ClientData();
        List<Client> myC = the.ClientList();
        System.out.println("size:" + myC.size());
        for(int i=0;i<myC.size();i++){
            System.out.println(myC.get(i).getUsername()+myC.get(i).getPassword()+myC.get(i).getContactnr()+myC.get(i).getAdminRights());
        }
    }
}
