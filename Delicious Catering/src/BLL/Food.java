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
    public String getFoodCourseType() {
        return foodCourseType;
    }
    public String getFoodName() {
        return foodName;
    }
    public double getFoodPrice() {
        return foodPrice;
    }
}