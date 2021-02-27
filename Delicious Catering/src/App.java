import java.util.*;

import BLL.*;
import DAL.*;
public class App {
    public static void main(String[] args) throws Exception {
        BeverageData the = new BeverageData();
        List<Beverage> myB = the.BeveragesList();
        System.out.println("size:" + myB.size());
        for(int i=0;i<myB.size();i++){
            System.out.println("Name: "+ myB.get(i).GetBeverageName() +" Price: "+myB.get(i).GetBeveragePrice());
        }
    }
}
