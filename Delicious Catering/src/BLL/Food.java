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
}
