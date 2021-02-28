import java.util.*;

import BLL.*;
import DAL.*;
public class App {
    public static void main(String[] args) throws Exception {
        OrderData the = new OrderData();
        List<Order> myO = the.ReadOrderList();
        System.out.println("size:" + myO.size());
        for(int i=0;i<myO.size();i++){
            System.out.println(myO.get(i).getUsername()+myO.get(i).getPassword()+myO.get(i).getContactnr()+myO.get(i).getAdminRights());
        }
    }
}
