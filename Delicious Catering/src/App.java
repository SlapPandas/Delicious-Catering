import java.util.*;

import BLL.*;
import DAL.*;
public class App {
    public static void main(String[] args) throws Exception {
        FoodData the = new FoodData();
        List<Food> myF = the.FoodList();
        System.out.println("size:" + myF.size());
        for(int i=0;i<myF.size();i++){
            System.out.println("type: "+ myF.get(i).GetFoodCourseType() +"  Name: "+ myF.get(i).GetFoodName() +"    Price: "+myF.get(i).GetFoodPrice());
        }
    }
}
