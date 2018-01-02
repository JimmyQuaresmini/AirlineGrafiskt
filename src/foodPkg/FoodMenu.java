package foodPkg;

import java.util.ArrayList;

/**
 * Created by Jimmy on 2016-11-23.
 */

//ny av mig för grafiska
public class FoodMenu {
    ArrayList<Food> foodList = new ArrayList<>();
    int totalFoodPrice;
    int tempFoodPrice;

    public FoodMenu() {
    }

    public FoodMenu(ArrayList<Food> foodList) {
        this.foodList = foodList;
        for (Food f : foodList) {
            tempFoodPrice = tempFoodPrice + f.getPrice();
        }
        setTotalFoodPrice(tempFoodPrice);
    }

    public FoodMenu(Food... foods) {
        for(Food f : foods){
            foodList.add(f);
            tempFoodPrice = tempFoodPrice + f.getPrice();
        }
        setTotalFoodPrice(tempFoodPrice);
    }

    public ArrayList<Food> getFoodList() {
        return foodList;
    }

    public void setFoodList(ArrayList<Food> foodList) {
        this.foodList = foodList;
    }

    public int getTotalFoodPrice() {
        return totalFoodPrice;
    }

    public void setTotalFoodPrice(int totalFoodPrice) {
        this.totalFoodPrice = totalFoodPrice;
    }
}
