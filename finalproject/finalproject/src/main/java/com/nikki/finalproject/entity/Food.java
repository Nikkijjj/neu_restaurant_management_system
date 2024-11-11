package com.nikki.finalproject.entity;

public class Food {

    private int foodId;
    private String foodName;
    private String description;
    private float price;
    private String foodPic;

    public Food() {}

    public Food(int foodId, String foodName, String description, float price) {
        this.foodId = foodId;
        this.foodName = foodName;
        this.description = description;
        this.price = price;
    }

    public String toString() {
        return "Food{" +
                "foodId=" + foodId +
                ", foodName='" + foodName + '\'' +
                ", description='" + description + '\'' +
                ", price='" + price + '\'' +
                ", foodPic='" + foodPic + '\'' +
                '}';
    }

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getFoodPic() {
        return foodPic;
    }

    public void setFoodPic(String foodPic) {
        this.foodPic = foodPic;
    }
}
