package BLL;
import DAL.*;
import java.util.*;

public class Food {
    private String foodCourseType;
    private String foodName;
    private double foodPrice;

    public Food(){}

    public Food(String courseType,String name, Double price){
        this.foodCourseType = courseType;
        this.foodName = name;
        this.foodPrice = price;
    }
    public String getFoodCourseType() {
        return foodCourseType;
    }
    public String getFoodName() {
        return foodName;
    }
    public double getFoodPrice() {
        return foodPrice;
    }

    public List<Food> DisplayFoodList(){
        FoodData myFood = new FoodData();
        return myFood.ReadFoodList();
    }

    public List<Food> GetFood(String foodtype)
    {
        FoodData fooddata = new FoodData();
        List<Food> foodlist = new ArrayList<>();
        List<Food> myFoodList = fooddata.ReadFoodList();

        for(int i = 0; i < myFoodList.size(); i++)
        {
            if(foodtype.equals(myFoodList.get(i).foodCourseType))
            {
                foodlist.add(myFoodList.get(i));
            }
        }

        return myFoodList;

    }
}
