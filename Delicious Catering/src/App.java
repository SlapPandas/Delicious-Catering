import java.util.*;

import BLL.*;
import DAL.*;
import java.text.*;

public class App {
    public static void main(String[] args) throws Exception {

        Order myOrder = new Order();

        //SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        //        //Date myDate = formatter.parse("10-05-2021");
        //        String myDate = "21-03-2021";

        System.out.println(myOrder.CheckDeposit(1,"Blue"));
        
    }
}
