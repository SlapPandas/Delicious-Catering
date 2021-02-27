package BLL;

public class Food {
    private String foodCourseType;
    private String foodName;
    private double foodPrice;

    public Food(String courseType,String name, Double price){
        this.foodCourseType = courseType;
        this.foodName = name;
        this.foodPrice = price;
    }
    public String GetFoodCourseType(){
        return this.foodCourseType;
    }
    public String GetFoodName(){
        return this.foodName;
    }
    public Double GetFoodPrice(){
        return this.foodPrice;
    }
}
